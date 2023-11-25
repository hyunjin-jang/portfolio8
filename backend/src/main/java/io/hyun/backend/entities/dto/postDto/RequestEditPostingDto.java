package io.hyun.backend.entities.dto.postDto;

import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestEditPostingDto {
    private Long postingId;
    private String postingTitle;
    private String postingContent;
    private String postingFile;
    private LocalDateTime editPostingDate;
    private User user;
}
