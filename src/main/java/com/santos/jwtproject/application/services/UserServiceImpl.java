package com.santos.jwtproject.application.services;

import com.santos.jwtproject.application.domain.User;
import com.santos.jwtproject.application.ports.PasswordEncoderPort;
import com.santos.jwtproject.application.ports.UserRepositoryPort;
import com.santos.jwtproject.application.ports.UserServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserServicePort {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;

    @Override
    public User findByLogin(String login) {
        return userRepositoryPort.findByLogin(login);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoderPort.encoder(user.getPassword()));
        return userRepositoryPort.save(user);
    }
}
