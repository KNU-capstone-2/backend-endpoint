package com.knu.cloudapi.adapter.in.web;

import com.knu.cloudapi.application.dto.request.PostKeypairRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;
import com.knu.cloudapi.application.dto.response.GetFlavorResponse;
import com.knu.cloudapi.application.dto.response.GetImageResponse;
import com.knu.cloudapi.application.dto.response.GetKeypairResponse;
import com.knu.cloudapi.application.dto.response.GetNetworkResponse;
import com.knu.cloudapi.application.dto.response.PostKeypairResponse;
import com.knu.cloudapi.application.port.in.GetProjectResponse;
import com.knu.cloudapi.application.port.in.InstanceOptionsUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class InstanceOptionsController {

    private final InstanceOptionsUsecase instanceOptionsUsecase;

    @GetMapping("flavors")
    public ResponseEntity<ApiResponse<List<GetFlavorResponse>>> getFlavorList() {
        return ResponseEntity.ok().body(new ApiResponse<>(1000, "OK", instanceOptionsUsecase.getFlavorList()));
    }

    @GetMapping("flavor/{id}")
    public ResponseEntity<ApiResponse<GetFlavorResponse>> getFlavorList(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(new ApiResponse<>(1000, "OK", instanceOptionsUsecase.getFlavorById(id)));
    }

    @GetMapping("networks")
    public ResponseEntity<ApiResponse<List<GetNetworkResponse>>> getNetworkList() {
        return ResponseEntity.ok().body(new ApiResponse<>(1000, "OK", instanceOptionsUsecase.getNetworkList()));
    }

    @GetMapping("network/{id}")
    public ResponseEntity<ApiResponse<GetNetworkResponse>> getNetworkById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(new ApiResponse<>(1000, "OK", instanceOptionsUsecase.getNetworkById(id)));
    }

    @GetMapping("keypairs")
    public ResponseEntity<ApiResponse<List<GetKeypairResponse>>> getKeypairList() {
        return ResponseEntity.ok().body(new ApiResponse<>(1000, "OK", instanceOptionsUsecase.getKeypairList()));
    }

    @GetMapping("keypair/{id}")
    public ResponseEntity<ApiResponse<GetKeypairResponse>> getKeypairById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(new ApiResponse<>(1000, "OK", instanceOptionsUsecase.getKeypairById(id)));
    }

    @GetMapping("images")
    public ResponseEntity<ApiResponse<List<GetImageResponse>>> getImageList() {
        return ResponseEntity.ok().body(new ApiResponse<>(1000, "OK", instanceOptionsUsecase.getImageList()));
    }

    @GetMapping("image/{id}")
    public ResponseEntity<ApiResponse<GetImageResponse>> getImageById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(new ApiResponse<>(1000, "OK", instanceOptionsUsecase.getImageById(id)));
    }

    @PostMapping("keypair")
    public ResponseEntity<ApiResponse<PostKeypairResponse>> postKeypair(@RequestBody PostKeypairRequest request) {
        return ResponseEntity.ok().body(new ApiResponse<>(1000, "OK", instanceOptionsUsecase.postKeypair(request)));
    }


    @GetMapping( "project")
    public ResponseEntity<GetProjectResponse> getOpenStackProject() {
        return ResponseEntity.ok().body(instanceOptionsUsecase.getOpenStackProject());
    }

    @DeleteMapping("keypair/{id}")
    public ResponseEntity<ApiResponse<String>> deleteKeypairById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(new ApiResponse<>(1000, "OK", instanceOptionsUsecase.deleteKeypair(id)));
    }

}
