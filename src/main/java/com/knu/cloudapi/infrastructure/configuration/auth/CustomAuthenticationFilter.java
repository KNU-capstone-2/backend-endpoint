package com.knu.cloudapi.infrastructure.configuration.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knu.cloudapi.application.dto.request.LoginRequest;
import com.knu.cloudapi.application.dto.response.ApiResponse;
import com.knu.cloudapi.application.dto.response.ApiStatus;
import com.knu.cloudapi.domain.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 시큐리티 인증 커스텀 필터, 로그인 성공/실패 처리 여기서 함
 * @author ChangEn Yea
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  public CustomAuthenticationFilter(AuthenticationManager authenticationManager){
    setAuthenticationManager(authenticationManager);
    setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/auth/login", HttpMethod.POST.name()));
  }

  private User user;


  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    if(!request.getMethod().equals(HttpMethod.POST.name())) {
      throw new AuthenticationServiceException("Authentication method not supported");
    }


    ObjectMapper mapper = new ObjectMapper();
    UsernamePasswordAuthenticationToken authRequest;

    try (InputStream requestBody = request.getInputStream()) {
      LoginRequest loginRequest = mapper.readValue(requestBody, LoginRequest.class);
      authRequest = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
    } catch (IOException e) {
      throw new AuthenticationServiceException("Failed to read user credentials");
    }

    setDetails(request, authRequest);

    return getAuthenticationManager().authenticate(authRequest);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain, Authentication authentication) throws IOException, ServletException {
    SecurityContextHolder.getContext().setAuthentication(authentication);
    HttpSession session = request.getSession(true);
    session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
        SecurityContextHolder.getContext());

    // Return a success response
    response.setStatus(HttpStatus.OK.value());
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.getWriter().write(new ObjectMapper().writeValueAsString(new ApiResponse<Object>(
        ApiStatus.OK, "OK", null)));
  }

  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException failed) throws IOException, ServletException {
    response.sendError(401, "INVALID_USERNAME_PASSWORD");
  }


}