package com.spiderBooksShopping.successHandler;

import com.spiderBooksShopping.controller.HomeController;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class SuccessHandler implements AuthenticationSuccessHandler {

    private static Logger logger = LogManager.getLogger(HomeController.class);

    private RedirectStrategy redir = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        BasicConfigurator.configure();
        logger.info(" Inside  Authentication Success Handler method at SuccessHandler class");
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                redir.sendRedirect(httpServletRequest, httpServletResponse, "/allCustomersData");
            } else {
                redir.sendRedirect(httpServletRequest, httpServletResponse, "/customerHome");
            }
        }
    }
}
