package com.knu.cloudapi.application.port.in;

import com.knu.cloudapi.application.dto.request.SignUpRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;

public interface UserUsecase {
  ApiResponse<Object> signUp(SignUpRequest request);
}
