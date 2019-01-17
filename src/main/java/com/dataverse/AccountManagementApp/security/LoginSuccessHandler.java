package com.dataverse.AccountManagementApp.security;

import com.dataverse.AccountManagementApp.enums.RoleType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final String TIMESTAMP_COOKIE_NAME = "TIMESTAMP";
    private static final String USER_HOME_PAGE_URL = "/profile";

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //loginAttemptService.loginSucceeded(request.getSession());

        response.addCookie(generateTimestampCookie());

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String redirectUrl = null;
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals(RoleType.USER.name())) {
                redirectUrl = USER_HOME_PAGE_URL;
            }

        }
        redirectStrategy.sendRedirect(request, response, redirectUrl);
    }


    private Cookie generateTimestampCookie() {
        return new Cookie(TIMESTAMP_COOKIE_NAME, String.valueOf(System.currentTimeMillis()));
    }


}