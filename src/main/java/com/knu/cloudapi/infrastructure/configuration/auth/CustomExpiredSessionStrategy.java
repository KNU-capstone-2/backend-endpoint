package com.knu.cloudapi.infrastructure.configuration.auth;

import jakarta.servlet.ServletException;
import java.io.IOException;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * 요청 해당 세션 만료시 예외처리용 구현체
 * @author ChangEn Yea
 */
public class CustomExpiredSessionStrategy implements SessionInformationExpiredStrategy {

  @Override
  public void onExpiredSessionDetected(SessionInformationExpiredEvent event)
      throws IOException, ServletException {
    System.out.println("hi");
    event.getResponse().sendError(401, "SESSION_EXPIRED");
  }
}
