package io.hyun.backend.entities.dto;

import io.hyun.backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPostingDto {
    private String postingTitle;
    private String postingContent;
    private String postingDate;
    private String postingFile;
    private User user;
}
