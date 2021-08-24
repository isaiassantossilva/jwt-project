package com.santos.jwtproject.application.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String id;
    private String login;
    private String password;
}
