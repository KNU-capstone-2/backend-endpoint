package com.knu.cloudapi.application.service;

import com.knu.cloudapi.application.dto.EndPointOpenStackMapper;
import com.knu.cloudapi.application.dto.openstack.response.*;
import com.knu.cloudapi.application.dto.request.PostKeypairRequest;
import com.knu.cloudapi.application.dto.response.*;
import com.knu.cloudapi.application.port.in.InstanceOptionsUsecase;
import com.knu.cloudapi.application.port.out.OpenStackPort;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InstanceOptionsService implements InstanceOptionsUsecase {

    private final EndPointOpenStackMapper mapper;

    private final OpenStackPort openStackPort;

    @Override
    public List<GetFlavorResponse> getFlavorList() {
        List<GetFlavorResponse> data = new ArrayList<>();
        List<GetOpenStackFlavorResponse> openStackResponse = openStackPort.getFlavorList();

        for (GetOpenStackFlavorResponse res: openStackResponse) {
            data.add(mapper.transGetFlavorRes(res));
        }

        return data;
    }

    @Override
    public GetFlavorResponse getFlavorById(String id) {
        return mapper.transGetFlavorRes(openStackPort.getFlavor(id));
    }

    @Override
    public List<GetImageResponse> getImageList() {
        List<GetImageResponse> data = new ArrayList<>();
        List<GetOpenStackImageResponse> openStackResponse = openStackPort.getImageList();

        for (GetOpenStackImageResponse res: openStackResponse) {
            data.add(mapper.transGetImageRes(res));
        }

        return data;
    }

    @Override
    public GetImageResponse getImageById(String id) {
        return mapper.transGetImageRes(openStackPort.getImage(id));
    }

    @Override
    public List<GetKeypairResponse> getKeypairList() {
        List<GetKeypairResponse> data = new ArrayList<>();
        List<GetOpenStackKeypairResponse> openStackResponse = openStackPort.getKeypairList();

        for (GetOpenStackKeypairResponse res: openStackResponse) {
            data.add(mapper.transGetKeypairRes(res));
        }

        return data;
    }

    @Override
    public GetKeypairResponse getKeypairById(String id) {
        return mapper.transGetKeypairRes(openStackPort.getKeypair(id));
    }

    @Override
    public List<GetNetworkResponse> getNetworkList() {
        List<GetNetworkResponse> data = new ArrayList<>();
        List<GetOpenStackNetworkResponse> openStackResponse = openStackPort.getNetworkList();

        for (GetOpenStackNetworkResponse res: openStackResponse) {
            data.add(mapper.transGetNetworkRes(res));
        }

        return data;
    }

    @Override
    public GetNetworkResponse getNetworkById(String id) {
        return mapper.transGetNetworkRes(openStackPort.getNetwork(id));
    }

    @Override
    public PostKeypairResponse postKeypair(PostKeypairRequest request) {

        return mapper.transPostKeypairRes(openStackPort.postKeypair(request.getKeypairName(),  request.getKeypairType()));
    }

    @Override
    public GetProjectResponse getOpenStackProject() {
        return mapper.transGetProjectRes(openStackPort.getProject());
    }
}
