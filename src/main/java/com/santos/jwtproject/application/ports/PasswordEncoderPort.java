package com.santos.jwtproject.application.ports;

public interface PasswordEncoderPort {
    String encoder(String password);
}
