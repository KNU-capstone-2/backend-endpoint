package com.knu.cloudapi.application.service;

import com.knu.cloudapi.application.dto.request.SignUpRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;
import com.knu.cloudapi.application.dto.response.ApiStatus;
import com.knu.cloudapi.application.port.in.UserUsecase;
import com.knu.cloudapi.application.port.out.UserPersistencePort;
import com.knu.cloudapi.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserUsecase {

  private final UserPersistencePort userPersistencePort;

  @Override
  public ApiResponse<Object> signUp(SignUpRequest request) {
    return null;
  }
}
