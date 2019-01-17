package com.nc.webapp.service;

import com.nc.webapp.model.Users;

public interface UserAccountService {
    Users getUserByToken(String token);
}
