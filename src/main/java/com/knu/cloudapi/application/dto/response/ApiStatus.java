package com.knu.cloudapi.application.dto.response;

public interface ApiStatus {
  int OK = 1000;

  int INVALID_USERNAMEPASSWORD = 2101;
  int SESSION_EXPIRED = 2102;
}
