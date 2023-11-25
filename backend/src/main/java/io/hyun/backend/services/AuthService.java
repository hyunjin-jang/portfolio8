package io.hyun.backend.services;

import io.hyun.backend.entities.User;
import io.hyun.backend.entities.dto.authDto.JoinRequestDto;
import io.hyun.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public void join(JoinRequestDto dto) {
        User user = User.builder()
                .userEmail(dto.getUserEmail())
                .userPassword(dto.getUserPassword())
                .userNickName(dto.getUserNickName())
                .build();
        userRepository.save(user);
    }
}
