package io.hyun.backend.entities.dto.authDto;

import io.hyun.backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLoginDto {
    private LocalDateTime expireTime;
    private String token;
    private User user;
}
