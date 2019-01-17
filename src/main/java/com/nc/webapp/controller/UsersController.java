package com.nc.webapp.controller;

import com.nc.webapp.dto.UsersDTO;
import com.nc.webapp.model.Users;
import com.nc.webapp.service.UserAccountService;
import com.nc.webapp.util.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.nc.webapp.security.SecurityConstants.HEADER_STRING;

@RestController
@RequestMapping("/users")
class UsersController {

    private final UserAccountService userAccountService;
    private final ModelMapper modelMapper;

    public UsersController(UserAccountService userAccountService, ModelMapper modelMapper) {
        this.userAccountService = userAccountService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/logged-user", method = RequestMethod.GET)
    public UsersDTO getLoggedUser(HttpServletRequest request) {
        Users user = RestPreconditions.checkFound(userAccountService.getUserByToken(request.getHeader(HEADER_STRING)));
        return modelMapper.map(user, UsersDTO.class);
    }

}
