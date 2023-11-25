package io.hyun.backend.entities.dto;

import io.hyun.backend.entities.Posting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserPostingDto {
    private String postingTitle;
    private LocalDateTime postingDate;
    private String postingFile;

    public ResponseUserPostingDto(Posting posting) {
        postingTitle = posting.getPostingTitle();
        postingFile = posting.getPostingFile();
        postingDate = posting.getPostingDate();
    }
}
