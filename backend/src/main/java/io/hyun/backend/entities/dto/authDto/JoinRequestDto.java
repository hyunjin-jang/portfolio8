package io.hyun.backend.entities.dto.authDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JoinRequestDto {
    private String userEmail;
    private String userPassword;
    private String userNickName;
}
