package io.hyun.backend.entities.dto.authDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestLoginDto {
    private String userEmail;
    private String userPassword;
}
