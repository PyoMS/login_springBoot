package com.board.login.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("RestAuthenticationEntryPoint : "+request.getRequestURL().toString());
        if (request.getRequestURL().indexOf("/api/") < 0) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }else{
//            response.sendRedirect("/web/login");
            log.info("RestAuthenticationEntryPoint - else");
        }
    }
}
