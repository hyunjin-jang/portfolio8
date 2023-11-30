package io.hyun.backend.services;

import io.hyun.backend.entities.User;
import io.hyun.backend.entities.dto.authDto.RequestLoginDto;
import io.hyun.backend.entities.dto.authDto.ResponseLoginDto;
import io.hyun.backend.entities.dto.authDto.JoinRequestDto;
import io.hyun.backend.entities.dto.authDto.SimpleUserDto;
import io.hyun.backend.repositories.UserRepository;
import io.hyun.backend.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public void join(JoinRequestDto dto) {
        User user = User.builder()
                .userEmail(dto.getUserEmail())
                .userPassword(dto.getUserPassword())
                .userNickName(dto.getUserNickName())
                .build();
        userRepository.save(user);
    }

    public ResponseLoginDto login(RequestLoginDto dto) {
        if(!userRepository.existsByUserEmail(dto.getUserEmail())) {
            return null;
        }
        User foundUser = userRepository.findByUserEmail(dto.getUserEmail());
        if(foundUser.getUserPassword().equals(dto.getUserPassword())) {
            int expireTime = 360000;
            String token = jwtTokenProvider.jwtCreate(foundUser.getUserEmail());
            SimpleUserDto user = new SimpleUserDto(foundUser.getUserEmail(), foundUser.getUserNickName());
            return new ResponseLoginDto(expireTime, token, user);
        }
        return null;
    }

    public void logout() {
    }
}
