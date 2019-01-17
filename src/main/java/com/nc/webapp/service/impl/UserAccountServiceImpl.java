package com.nc.webapp.service.impl;

import com.nc.webapp.exception.AppRuntimeException;
import com.nc.webapp.exception.code.AppExceptionCode;
import com.nc.webapp.model.Users;
import com.nc.webapp.repository.UsersRepository;
import com.nc.webapp.service.UserAccountService;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import static com.nc.webapp.security.SecurityConstants.SECRET;
import static com.nc.webapp.security.SecurityConstants.TOKEN_PREFIX;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UsersRepository usersRepository;

    public UserAccountServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users getUserByToken(String token) {
        if (token == null) {
            throw new AppRuntimeException(AppExceptionCode.E001);
        }

        String username = Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();

        return usersRepository.findByUsername(username);
    }
}
