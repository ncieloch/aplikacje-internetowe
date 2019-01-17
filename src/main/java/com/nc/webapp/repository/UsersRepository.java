package com.nc.webapp.repository;

import com.nc.webapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {

     Users findByUsername(String username);
}
