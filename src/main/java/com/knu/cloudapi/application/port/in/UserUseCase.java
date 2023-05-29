package com.knu.cloudapi.application.port.in;

import com.knu.cloudapi.application.dto.request.JoinRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;

public interface UserUseCase {
  ApiResponse<Object> join(JoinRequest request);
}
