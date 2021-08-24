package com.santos.jwtproject.adapters.inbound.controllers.user;

import com.santos.jwtproject.application.domain.User;
import com.santos.jwtproject.application.ports.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServicePort userServicePort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userServicePort.save(user);
    }
}
