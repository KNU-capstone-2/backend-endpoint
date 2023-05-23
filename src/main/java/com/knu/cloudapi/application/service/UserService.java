package com.knu.cloudapi.application.service;

import com.knu.cloudapi.application.dto.request.JoinRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;
import com.knu.cloudapi.application.dto.response.ApiStatus;
import com.knu.cloudapi.application.port.in.UserUseCase;
import com.knu.cloudapi.application.port.out.UserPersistencePort;
import com.knu.cloudapi.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserPersistencePort userPersistencePort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ApiResponse<Object> join(JoinRequest request) {
        userPersistencePort.save(new User(request.getUsername(), request.getEmail(), bCryptPasswordEncoder.encode(request.getPassword()), "ROLE_USER"));
        return new ApiResponse<>(ApiStatus.OK, "Success SignUp", null);
    }
}
