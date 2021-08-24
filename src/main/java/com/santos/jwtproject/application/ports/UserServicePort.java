package com.santos.jwtproject.application.ports;

import com.santos.jwtproject.application.domain.User;

public interface UserServicePort {
    User findByLogin(String login);
    User save(User user);
}
