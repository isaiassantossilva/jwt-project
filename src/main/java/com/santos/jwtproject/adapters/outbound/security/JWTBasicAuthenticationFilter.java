package com.santos.jwtproject.adapters.outbound.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class JWTBasicAuthenticationFilter extends BasicAuthenticationFilter {

    public static final String HEADER_FIELD = "Authorization";
    public static final String PREFIX = "Bearer ";

    public JWTBasicAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        var field = request.getHeader(HEADER_FIELD);

        if(isNull(field) || !field.startsWith(PREFIX)){
            chain.doFilter(request, response);
            return;
        }

        var token = field.replace(PREFIX, "");
        var authenticationToken = usernamePasswordAuthenticationToken(token);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken(String token){
        var user = JWT.require(Algorithm.HMAC512(JWTAuthenticationFilter.TOKEN_PASSWORD))
                .build()
                .verify(token)
                .getSubject();

        if(nonNull(user))
            return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());

        return null;
    }
}
