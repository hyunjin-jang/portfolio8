package io.hyun.backend.controllers;

import io.hyun.backend.entities.dto.authDto.RequestLoginDto;
import io.hyun.backend.entities.dto.authDto.ResponseLoginDto;
import io.hyun.backend.entities.dto.authDto.JoinRequestDto;
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

    @PostMapping("/login")
    public ResponseLoginDto login(@RequestBody RequestLoginDto dto) {
        return authService.login(dto);
    }

    public void logout() {
        authService.logout();
    }
}
