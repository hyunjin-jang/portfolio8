package io.hyun.backend.controllers;

import io.hyun.backend.entities.dto.authDto.RequestLoginDto;
import io.hyun.backend.entities.dto.authDto.ResponseLoginDto;
import io.hyun.backend.entities.dto.authDto.JoinRequestDto;
import io.hyun.backend.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/home")
    public String home() {
        return "<h1>Home</h1>";
    }

    @PostMapping("/main")
    public String main() {
        return "<h1>Main</h1>";
    }

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
