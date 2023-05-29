package com.knu.cloudapi.application.service;

import com.knu.cloudapi.application.dto.request.JoinRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;
import com.knu.cloudapi.application.dto.response.ApiStatus;
import com.knu.cloudapi.application.port.in.UserUseCase;
import com.knu.cloudapi.application.port.out.UserPersistencePort;
import com.knu.cloudapi.common.Role;
import com.knu.cloudapi.domain.User;
import com.knu.cloudapi.infrastructure.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserPersistencePort userPersistencePort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ApiResponse<Object> join(JoinRequest request) {
        if (userPersistencePort.findByUsername(request.getUsername()) != null) {
            return new ApiResponse<>(ApiStatus.OK, "Username is already exist", null);
        }else if(userPersistencePort.findByEmail(request.getEmail()) != null){
            return new ApiResponse<>(ApiStatus.OK, "Email is already exist", null);
        }else{
            userPersistencePort.save(new User(request.getUsername(), request.getEmail(), bCryptPasswordEncoder.encode(request.getPassword()), Role.USER));
            return new ApiResponse<>(ApiStatus.OK, "Success SignUp", null);
        }
    }
}
