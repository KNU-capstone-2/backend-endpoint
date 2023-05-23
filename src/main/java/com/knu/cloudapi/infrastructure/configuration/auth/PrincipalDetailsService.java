package com.knu.cloudapi.infrastructure.configuration.auth;

import com.knu.cloudapi.application.port.out.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 유저 인증 처리용 UserDetailsService 구현체
 * @author ChangEn Yea
 */
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

  private final UserPersistencePort userPersistencePort;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println(username);
    return new PrincipalDetails(userPersistencePort.findByUsername(username));
  }
}
