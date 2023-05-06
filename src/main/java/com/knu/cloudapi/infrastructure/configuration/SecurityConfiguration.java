package com.knu.cloudapi.infrastructure.configuration;

import com.knu.cloudapi.infrastructure.configuration.auth.CustomAuthenticationFilter;
import com.knu.cloudapi.infrastructure.configuration.auth.CustomExpiredSessionStrategy;
import com.knu.cloudapi.infrastructure.configuration.auth.CustomInvalidSessionStrategy;
import com.knu.cloudapi.infrastructure.configuration.auth.PrincipalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 시큐리티 인증/인가 설정
 * @author ChangEn Yea
 */
@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .headers().frameOptions().disable();

        http.addFilterBefore(new CustomAuthenticationFilter(authenticationManager(http.getSharedObject(
                AuthenticationConfiguration.class))), UsernamePasswordAuthenticationFilter.class);

//    세션 관리
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // 세션 정책: 필요시 세션 생성
                .maximumSessions(1) // 유저당 최대 세션 수
                .maxSessionsPreventsLogin(false)
                .expiredSessionStrategy(new CustomExpiredSessionStrategy()).and() // 동시 로그인 관련 기존 세션 만료
                .invalidSessionStrategy(new CustomInvalidSessionStrategy()) // 세션 무효시 커스텀 필터
                .sessionFixation().changeSessionId(); // 세션 고정 보호

        http
                .authorizeHttpRequests()
                .requestMatchers("/auth-test").hasRole("USER")
                .anyRequest().permitAll();

        return http.build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

}
