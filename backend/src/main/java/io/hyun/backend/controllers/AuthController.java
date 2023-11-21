package io.hyun.backend.controllers;

import io.hyun.backend.entities.dto.JoinRequestDto;
import io.hyun.backend.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/join")
    public void join(@RequestBody JoinRequestDto dto) {
        authService.join(dto);
    }
}
