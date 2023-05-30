package com.knu.cloudapi.application.dto.response;

public interface ApiStatus {
  int OK = 1000;
  int FAIL = 2000;
  int INVALID_USERNAMEPASSWORD = 2101;
  int SESSION_EXPIRED = 2102;
  int INVALID_USERNAME = 2103;
  int INVALID_EMAIL = 2104;
}
