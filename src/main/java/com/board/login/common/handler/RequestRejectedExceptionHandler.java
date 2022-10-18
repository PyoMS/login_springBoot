package com.board.login.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
@Slf4j
public class RequestRejectedExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 더블슬래시 : '//' 접근 시 RequestRejectedException 발생. 해당 Exception은 Security에서 먼저 catch하므로
     * Web 단에서 처리해 줄 수 없으니 Security 단에서 Handling 할 것.
     * */
    @Around("execution(public void org.springframework.security.web.FilterChainProxy.doFilter(..))")
    public void handleRequestRejectedException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        try {
            proceedingJoinPoint.proceed();
        } catch (RequestRejectedException e) {
            HttpServletRequest request = (HttpServletRequest) proceedingJoinPoint.getArgs()[0];
            log.info("{} : {}" ,e.getMessage(), request.getRequestURL());
            HttpServletResponse response = (HttpServletResponse) proceedingJoinPoint.getArgs()[1];
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
