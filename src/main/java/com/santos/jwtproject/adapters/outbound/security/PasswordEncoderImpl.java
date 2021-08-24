package com.santos.jwtproject.adapters.outbound.security;

import com.santos.jwtproject.application.ports.PasswordEncoderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordEncoderImpl implements PasswordEncoderPort {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encoder(String password) {
        return passwordEncoder.encode(password);
    }
}
