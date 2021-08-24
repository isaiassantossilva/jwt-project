package com.santos.jwtproject.adapters.inbound.controllers.health;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Health health(){
        return new Health("UP");
    }

    @Getter
    @RequiredArgsConstructor
    private static class Health {
        private final String status;
    }
}
