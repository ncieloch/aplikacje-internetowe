package com.nc.webapp.security;

import com.nc.webapp.model.Users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.nc.webapp.security.SecurityConstants.AUTHORITIES_KEY;
import static com.nc.webapp.security.SecurityConstants.HEADER_STRING;
import static com.nc.webapp.security.SecurityConstants.TOKEN_PREFIX;
import static com.nc.webapp.security.SecurityConstants.EXPIRATION_TIME;
import static com.nc.webapp.security.SecurityConstants.SECRET;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            Users creds = new ObjectMapper()
                    .readValue(request.getInputStream(), Users.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPasswd(),
                            Lists.newArrayList()
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication auth) {
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) auth.getAuthorities();
        List<String> roles = Lists.newArrayList();

        for (GrantedAuthority ga : authorities) {
            roles.add(ga.getAuthority());
        }

        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .claim(AUTHORITIES_KEY, roles)
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }   

}
