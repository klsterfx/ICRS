package com.project.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// set our response to OK status
		response.setStatus(HttpServletResponse.SC_OK);

		boolean admin = false;
		boolean user = false;

		System.out.println("AT onAuthenticationSuccess(...) function!");

		System.out.println(authentication.getAuthorities());
		
		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if ("ROLE_ADMIN".equals(auth.getAuthority())) {
				admin = true;
			}
			if ("ROLE_USER".equals(auth.getAuthority())) {
				user = true; 
			}
			
		}

		if (admin) {
			System.out.println("user is admin");
			response.sendRedirect("/admin/index");
		} 
		if (user) {
			System.out.println("user is user");
			response.sendRedirect("/user/index");
		} 

	}
}