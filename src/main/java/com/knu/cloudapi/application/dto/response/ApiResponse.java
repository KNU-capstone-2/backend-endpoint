package com.knu.cloudapi.application.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@Getter
public class ApiResponse<T> {
  private int status;

  private String message;

  private T data;

}
