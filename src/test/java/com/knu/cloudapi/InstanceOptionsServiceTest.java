package com.knu.cloudapi;

import com.knu.cloudapi.adapter.out.OpenStackAdapter;
import com.knu.cloudapi.application.dto.EndPointOpenStackMapper;
import com.knu.cloudapi.application.dto.EndPointOpenStackMapperImpl;
import com.knu.cloudapi.application.dto.response.GetFlavorResponse;
import com.knu.cloudapi.application.port.in.InstanceOptionsUsecase;
import com.knu.cloudapi.application.port.out.OpenStackPort;
import com.knu.cloudapi.application.service.InstanceOptionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InstanceOptionsServiceTest {

    private InstanceOptionsUsecase service;
    private OpenStackPort port;
    private EndPointOpenStackMapper mapper;

    @BeforeEach
    public void beforeEach() {
        this.service = new InstanceOptionsService(new EndPointOpenStackMapperImpl(), new OpenStackAdapter());
    }

    @Test
    void test() {
        for (GetFlavorResponse res: service.getFlavorList()) {
            System.out.println(res.getName());
        }

        System.out.println(service.getFlavorById("1").getName());
    }
}
