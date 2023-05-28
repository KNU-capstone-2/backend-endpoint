package com.knu.cloudapi.adapter.in.web;

import com.knu.cloudapi.application.dto.request.InstanceRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;
import com.knu.cloudapi.application.dto.response.ApiStatus;
import com.knu.cloudapi.application.dto.response.InstanceResponse;
import com.knu.cloudapi.application.port.in.InstanceUseCase;
import com.knu.cloudapi.domain.Instance;
import com.knu.cloudapi.infrastructure.auth.PrincipalDetails;
import com.knu.cloudapi.infrastructure.persistence.mapper.InstanceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class InstanceController {
    private final InstanceUseCase instanceUseCase;
    private final InstanceMapper instanceMapper;

    @GetMapping(path = "/instance/{id}")
    public ResponseEntity<ApiResponse<InstanceResponse>> getInstance(@PathVariable("id") Long id) {
        InstanceResponse instanceResponse = instanceMapper.toResponseDto(instanceUseCase.getInstance(id));
        return ResponseEntity.ok().body(new ApiResponse<InstanceResponse>(ApiStatus.OK, "OK", instanceResponse));
    }

    @GetMapping(path = "/instances")
    public ResponseEntity<ApiResponse<ArrayList<InstanceResponse>>> getAllInstance() {
        ArrayList<Instance> instances = instanceUseCase.getAllInstance();
        ArrayList<InstanceResponse> instanceResponses = new ArrayList<>();
        if(instances != null) {
            for (Instance instance : instances) {
                instanceResponses.add(instanceMapper.toResponseDto(instance));
            }
        }
        return ResponseEntity.ok().body(new ApiResponse<ArrayList<InstanceResponse>>(ApiStatus.OK, "OK", instanceResponses));
    }

    /**
     * TODO:인스턴스 생성 에러 처리
     */
    @PostMapping("/instance")
    public ResponseEntity<ApiResponse<InstanceResponse>> createInstance(
            @RequestBody InstanceRequest instanceRequest, @AuthenticationPrincipal PrincipalDetails principalDetails
    ) {
        InstanceResponse instanceResponse = instanceMapper.toResponseDto(instanceUseCase.createInstance(instanceRequest, principalDetails.getUser()));
        return ResponseEntity.ok().body(new ApiResponse<InstanceResponse>(ApiStatus.OK, "OK", instanceResponse));
    }

    /**
     * TODO: 인스턴스 삭제 에러 처리
     */
    @DeleteMapping(path = "instance/{id}")
    public ResponseEntity<ApiResponse<String>> deleteInstance(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        boolean result = instanceUseCase.deleteInstance(id, principalDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponse<String>(ApiStatus.OK, "OK", result ? "complete delete instance" : "fail delete instance"));
    }
}
