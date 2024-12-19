package com.laphayen.board.aop;

import com.laphayen.board.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Set;

@Aspect
@Component
@Log4j2
public class LoginCheckAspect {

    private final HttpSession session;
    private final Set<String> whitelistUrls;

    public LoginCheckAspect(HttpSession session, Set<String> whitelistUrls) {
        this.session = session;
        this.whitelistUrls = whitelistUrls;
    }

    @Pointcut("within(com.laphayen.board.controller..*)")
    public void allControllerMethods() {
    }

    @Before("allControllerMethods()")
    public void checkLoginStatus(JoinPoint joinPoint) {
        String requestUri = session.getAttribute("REQUEST_URI").toString();

        if (whitelistUrls.contains(requestUri)) {
            log.info("Whitelist API 호출: {}", requestUri);
            return; // 화이트리스트 URL은 로그인 체크를 건너뜀
        }

        String loggedInUserId = SessionUtil.getLoginMemberId(session);
        if (loggedInUserId == null) {
            log.warn("로그인되지 않은 사용자가 접근 시도: {}", requestUri);
            throw new IllegalStateException("로그인이 필요합니다!");
        }

//        log.info("로그인 체크 통과: {}", loggedInUserId);
    }

}
