package com.knu.cloudapi.adapter.in.web;

import com.knu.cloudapi.application.dto.request.PostKeypairRequest;
import com.knu.cloudapi.application.dto.response.GetFlavorResponse;
import com.knu.cloudapi.application.dto.response.GetImageResponse;
import com.knu.cloudapi.application.dto.response.GetKeypairResponse;
import com.knu.cloudapi.application.dto.response.GetNetworkResponse;
import com.knu.cloudapi.application.dto.response.PostKeypairResponse;
import com.knu.cloudapi.application.port.in.InstanceOptionsUsecase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class InstanceOptionsController {

    private final InstanceOptionsUsecase instanceOptionsUsecase;

    @GetMapping("flavors")
    public ResponseEntity<List<GetFlavorResponse>> getFlavorList() {
        return ResponseEntity.ok().body(instanceOptionsUsecase.getFlavorList());
    }

    @GetMapping("flavor/{id}")
    public ResponseEntity<GetFlavorResponse> getFlavorList(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(instanceOptionsUsecase.getFlavorById(id));
    }

    @GetMapping("networks")
    public ResponseEntity<List<GetNetworkResponse>> getNetworkList() {
        return ResponseEntity.ok().body(instanceOptionsUsecase.getNetworkList());
    }

    @GetMapping("network/{id}")
    public ResponseEntity<GetNetworkResponse> getNetworkById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(instanceOptionsUsecase.getNetworkById(id));
    }

    @GetMapping("keypairs")
    public ResponseEntity<List<GetKeypairResponse>> getKeypairList() {
        return ResponseEntity.ok().body(instanceOptionsUsecase.getKeypairList());
    }

    @GetMapping("keypair/{id}")
    public ResponseEntity<GetKeypairResponse> getKeypairById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(instanceOptionsUsecase.getKeypairById(id));
    }

    @GetMapping("images")
    public ResponseEntity<List<GetImageResponse>> getImageList() {
        return ResponseEntity.ok().body(instanceOptionsUsecase.getImageList());
    }

    @GetMapping("image/{id}")
    public ResponseEntity<GetImageResponse> getImageById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(instanceOptionsUsecase.getImageById(id));
    }

    @PostMapping("keypair")
    public ResponseEntity<PostKeypairResponse> postKeypair(@RequestBody PostKeypairRequest request) {
        return ResponseEntity.ok().body(instanceOptionsUsecase.postKeypair(request));
    }
}
