package io.hyun.backend.entities.dto.authDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUserDto {
    private String userEmail;
    private String userNickName;

}
