package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.UserLoginDTO;
import com.dictionaryapp.model.dto.UserRegisterDTO;
import com.dictionaryapp.model.entity.User;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);

    boolean login(UserLoginDTO userLoginDTO);

    void logout();

    User getLoggedUser();

    boolean isLogged();
}
