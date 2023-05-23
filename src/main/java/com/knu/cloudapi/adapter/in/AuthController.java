package com.knu.cloudapi.adapter.in;

import com.knu.cloudapi.application.dto.request.JoinRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;
import com.knu.cloudapi.application.port.in.UserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserUseCase userUseCase;

    @PostMapping(path = "/join")
    public ResponseEntity<ApiResponse<Object>> join(@Valid @RequestBody JoinRequest request) {
        return ResponseEntity.ok().body(userUseCase.join(request));
    }

}
