package com.santos.jwtproject.adapters.outbound.security;

import com.santos.jwtproject.application.ports.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserServicePort userServicePort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userServicePort.findByLogin(username);

        if(isNull(user))
            throw new UsernameNotFoundException("User "+ username +" not found!");

        return new UserDetailsImpl(user);
    }
}
