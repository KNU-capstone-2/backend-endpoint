package com.knu.cloudapi.infrastructure.adapter.in;

import com.knu.cloudapi.application.dto.request.SignUpRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;
import com.knu.cloudapi.application.port.in.UserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserUseCase userUseCase;

    @PostMapping(path = "/user/sign-up")
    public ResponseEntity<ApiResponse<Object>> signUp(@Valid @RequestBody SignUpRequest request) {
        return ResponseEntity.ok().body(userUseCase.signUp(request));
    }

}
