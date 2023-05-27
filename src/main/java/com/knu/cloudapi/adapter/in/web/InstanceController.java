package com.knu.cloudapi.adapter.in.web;

import com.knu.cloudapi.application.dto.request.InstanceRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;
import com.knu.cloudapi.application.dto.response.ApiStatus;
import com.knu.cloudapi.application.dto.response.InstanceResponse;
import com.knu.cloudapi.application.port.in.InstanceUseCase;
import com.knu.cloudapi.application.port.in.UserUseCase;
import com.knu.cloudapi.domain.Instance;
import com.knu.cloudapi.infrastructure.persistence.mapper.InstanceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instances")
public class InstanceController {
    private final InstanceUseCase instanceUseCase;

    private final UserUseCase userUseCase;
    private final InstanceMapper instanceMapper;
    private final RestTemplate restTemplate;
    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<InstanceResponse>> getInstance(@PathVariable("id") Long id) {
        Instance instance = instanceUseCase.getInstance(id);
        return ResponseEntity.ok().body(new ApiResponse<InstanceResponse>(ApiStatus.OK, "OK", instanceMapper.toResponseDto(instance)));
    }

    @GetMapping
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
     * TODO:인스턴스 생성
     */
    @PostMapping
    public ResponseEntity<ApiResponse<InstanceResponse>> createInstance(@RequestBody InstanceRequest instanceRequest) {
        String apiUrl = "http://43.201.133.78:8000/create";
        ResponseEntity<InstanceResponse> responseEntity = restTemplate.postForEntity(apiUrl, instanceRequest, InstanceResponse.class);
        System.out.println("responseEntity = " + responseEntity);
        return ResponseEntity.ok().body(new ApiResponse<InstanceResponse>(ApiStatus.OK, "OK", responseEntity.getBody()));
    }

    /**
     * TODO: 인스턴스 삭제
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<String>> deleteInstance(@PathVariable("id") String id) {
        String apiUrl = "http://http://43.201.133.78:8000/delete/";
        restTemplate.delete(apiUrl, id);
        return ResponseEntity.ok().body(new ApiResponse<String>(ApiStatus.OK, "OK", "complete delete instance"));
    }
}
