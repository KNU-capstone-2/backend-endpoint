package com.knu.cloudapi.adapter.in;

import com.knu.cloudapi.application.dto.request.InstanceRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;
import com.knu.cloudapi.application.dto.response.ApiStatus;
import com.knu.cloudapi.application.dto.response.InstanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instances")
public class InstanceController {
    private final RestTemplate restTemplate;


    /**
     * 인스턴스 정보 조회
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<InstanceResponse>> getInstance(@PathVariable("id") String id){
        String apiUrl = "http://43.201.133.78:8000/getserver/" + id;
        ResponseEntity<InstanceResponse> responseEntity = restTemplate.getForEntity(apiUrl, InstanceResponse.class);
        return ResponseEntity.ok().body(new ApiResponse<InstanceResponse>(ApiStatus.OK, "OK", responseEntity.getBody()));
    }

    /**
     * 인스턴스 전체 조회
     */
    @GetMapping(path = "/")
    public ResponseEntity<ArrayList<InstanceResponse>> getAllInstance() {
        String apiUrl = "http://43.201.133.78:8000/getserver/";
        ResponseEntity<ArrayList> responseEntity = restTemplate.getForEntity(apiUrl, ArrayList.class);
        return null;
    }

    /**
     * 인스턴스 생성
     */
    @PostMapping(path = "/")
    public ResponseEntity<ApiResponse<InstanceResponse>> createInstance(@RequestBody InstanceRequest instanceRequest) {
        String apiUrl = "http://43.201.133.78:8000/create";
        ResponseEntity<InstanceResponse> responseEntity = restTemplate.postForEntity(apiUrl, instanceRequest, InstanceResponse.class);
        System.out.println("responseEntity = " + responseEntity);
        return ResponseEntity.ok().body(new ApiResponse<InstanceResponse>(ApiStatus.OK, "OK", responseEntity.getBody()));
    }

    /**
     * 인스턴스 삭제
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<String>> deleteInstance(@PathVariable("id") String id){
        String apiUrl = "http://http://43.201.133.78:8000/delete/";
        restTemplate.delete(apiUrl, id);
        return ResponseEntity.ok().body(new ApiResponse<String>(ApiStatus.OK, "OK", "complete delete instance"));
    }
}
