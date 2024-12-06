package com.laphayen.board.config;

import com.laphayen.board.aop.LoginCheckAspect;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class AspectConfig {

    private final HttpSession session;

    public AspectConfig(HttpSession session) {
        this.session = session;
    }

    @Bean
    public LoginCheckAspect loginCheckAspect() {
        Set<String> whitelistUrls = Set.of(
                "/api/users/register",
                "/api/users/login"
        );
        return new LoginCheckAspect(session, whitelistUrls);
    }

}
