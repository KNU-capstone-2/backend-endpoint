package com.knu.cloudapi.infrastructure.adapter.in;

import com.knu.cloudapi.application.dto.response.ApiResponse;
import com.knu.cloudapi.application.dto.response.ApiStatus;
import com.knu.cloudapi.application.port.in.UserUsecase;
import com.knu.cloudapi.application.port.out.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

  private final UserUsecase UserUsecase;

  @GetMapping("/")
  public ResponseEntity<ApiResponse<Object>> getRoot() {
    return ResponseEntity.ok().body(new ApiResponse<>(ApiStatus.OK, "OK", null));
  }
}
