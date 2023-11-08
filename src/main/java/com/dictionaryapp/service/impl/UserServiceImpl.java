package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.UserLoginDTO;
import com.dictionaryapp.model.dto.UserRegisterDTO;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.session.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    private LoggedUser userSession;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser userSession) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        User user = new User(userRegisterDTO.getUsername(),
                userRegisterDTO.getEmail(),
                passwordEncoder.encode(userRegisterDTO.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<User> optionalUser = this.userRepository.findByUsername(userLoginDTO.getUsername());
        if (optionalUser.isEmpty()) {
            return false;
        }

        User user = optionalUser.get();
        String rawPassword = userLoginDTO.getPassword();
        String encryptedPassword = user.getPassword();

        if (!passwordEncoder.matches(rawPassword, encryptedPassword)) {
            return false;
        }
        this.userSession.login(user);
        return true;
    }

    @Override
    public void logout() {
        this.userSession.logout();
    }

    @Override
    public User getLoggedUser() {

        Optional<User> optionalUser = this.userRepository.findById(this.userSession.getId());
        return optionalUser.get();
    }

    @Override
    public boolean isLogged() {

        return this.userSession.isLogged();
    }
}
