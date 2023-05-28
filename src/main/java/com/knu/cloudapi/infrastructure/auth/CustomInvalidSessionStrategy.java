package com.knu.cloudapi.infrastructure.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knu.cloudapi.application.dto.response.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NoArgsConstructor;
import org.springframework.security.web.session.InvalidSessionStrategy;

/**
 * 요청 해당 무효 세션 예외처리용 구현체
 * @author ChangEn Yea
 */
@NoArgsConstructor
public class CustomInvalidSessionStrategy implements InvalidSessionStrategy {

  @Override
  public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    response.sendError(401, "INVALID_USERNAMEPASSWORD");
  }
}
