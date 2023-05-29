package com.knu.cloudapi.application.service;

import com.knu.cloudapi.application.dto.Flavor;
import com.knu.cloudapi.application.dto.request.InstanceRequest;
import com.knu.cloudapi.application.port.in.InstanceUseCase;
import com.knu.cloudapi.application.port.out.*;
import com.knu.cloudapi.domain.*;
import com.knu.cloudapi.infrastructure.persistence.entity.InstanceEntity;
import com.knu.cloudapi.infrastructure.persistence.entity.UserEntity;
import com.knu.cloudapi.infrastructure.persistence.mapper.InstanceMapper;
import com.knu.cloudapi.infrastructure.persistence.mapper.UserRoleMapper;
import com.knu.cloudapi.infrastructure.persistence.mapper.UserUsageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InstanceService implements InstanceUseCase {
    private final InstanceRestTemplatePort instanceRestTemplatePort;
    private final InstancePersistencePort instancePersistencePort;
    private final UserPersistencePort userPersistencePort;
    private final UserUsagePersistencePort userUsagePersistencePort;
    private final FlavorRestTemplatePort flavorRestTemplatePort;
    private final ProjectUsageRestTemplatePort projectUsageRestTemplatePort;
    private final UserUsageMapper  userUsageMapper;
    private final UserRoleMapper userRoleMapper;
    private final InstanceMapper instanceMapper;

    @Override
    public Instance getInstance(Long id) {
        InstanceEntity instanceEntity = instancePersistencePort.getInstanceEntityById(id);
        Instance instance = instanceRestTemplatePort.getInstance(instanceMapper.fromEntity(instanceEntity).getInstanceName());
        instance.setId(instanceEntity.getId());
        instance.setCreatorName(userPersistencePort.findById(instanceEntity.getId()).map(UserEntity::getUsername).orElse(null));
        return instance;
    }

    @Override
    public ArrayList<Instance> getAllInstance() {
        ArrayList<Instance> instances = instanceRestTemplatePort.getAllInstance();
        for (Instance instance : instances) {
            try{
                instance.setId(instancePersistencePort.getInstanceEntityByName(instance.getInstanceName()).getId());
                instance.setCreatorName(userPersistencePort.findById(instance.getId()).map(UserEntity::getUsername).orElse(null));
            }catch(NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        return instances;
    }

    @Override
    public Instance createInstance(InstanceRequest instanceRequest, User user) {
        UserEntity userEntity = userPersistencePort.findById(user.getId()).orElse(null);
        UserUsage userUsage = userUsageMapper.fromEntity(Objects.requireNonNull(userEntity).getUserUsageEntity());
        UserRole userRole = userRoleMapper.fromEntity(Objects.requireNonNull(userEntity).getUserRoleEntity());

        Flavor flavor = flavorRestTemplatePort.getFlavor(instanceRequest.getFlavorName());
        ProjectUsage projectUsage = projectUsageRestTemplatePort.getProjectUsage();

        /**
         * Project: 인스턴스 개수 10, VCPU 개수 20, RAM 양 51200GB, HDD 용량 1000GB
         * User 제한: VCPU 개수 10, RAM 양 25600GB, HDD 용량 500GB
         */


        if (instanceRestTemplatePort.getInstance(instanceRequest.getServerName()) == null
                && userUsage.cmpUsage(userRole.getMaxVCpu(), userRole.getMaxRam(), userRole.getMaxHdd(), flavor)
                && projectUsage.cmpProjectUsage(10, 20, 51200, 1000, flavor)) {

            Instance instance = instanceRestTemplatePort.createInstance(instanceRequest);
            instance.setFlavorName(instanceRequest.getFlavorName());
            instance.setImageName(instanceRequest.getImageName());

            InstanceEntity instanceEntity = instancePersistencePort.save(instanceMapper.toEntity(instance));
            userEntity.addInstanceEntity(instanceEntity);
            userPersistencePort.save(userEntity);

            userUsage.addUsage(flavor.getVCpu(), flavor.getRam(), flavor.getDisk(), 1);
            userUsagePersistencePort.save(userUsageMapper.toEntity(userUsage));

            instance.setId(instanceEntity.getId());
            instance.setCreatorName(instanceEntity.getUserEntity().getUsername());
            return instance;
        }
        return null;
    }

    /**
     * 인스턴스 삭제 시 사용자가 생성한 인스턴스만 삭제 가능하도록 처리
     * Flavor api 요청
     * 사용자 사용량 업데이트
     * @param id
     * @return
     */
    @Override
    public boolean deleteInstance(Long id, User user) {
        InstanceEntity instanceEntity = instancePersistencePort.getInstanceEntityById(id);

        if(instanceEntity.getUserEntity().getId().equals(user.getId())){
            //인스턴스 삭제 by restTemplate
            instanceRestTemplatePort.deleteInstance(instanceEntity.getInstanceName());
            //인스턴스 삭제 by persistence
            instancePersistencePort.delete(id);
            //사용자 사용량 업데이트
            Flavor flavor = flavorRestTemplatePort.getFlavor(instanceEntity.getFlavorName());
            UserUsage userUsage = userUsageMapper.fromEntity(userUsagePersistencePort.getUserUsageById(user.getId()));
            userUsage.subUsage(flavor.getVCpu(), flavor.getRam(), flavor.getDisk(), 1);
            userUsagePersistencePort.save(userUsageMapper.toEntity(userUsage));
            return true;
        }
        return false;
    }


}
