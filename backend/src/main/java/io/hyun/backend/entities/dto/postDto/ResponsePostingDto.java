package io.hyun.backend.entities.dto.postDto;

import io.hyun.backend.entities.Posting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePostingDto {

    private String postingTitle;
    private String postingContent;
    private LocalDateTime postingDate;
    private String postingFile;
    private String userNickName;

    public ResponsePostingDto(Posting posting) {
        postingTitle = posting.getPostingTitle();
        postingContent = posting.getPostingContent();
        postingDate = posting.getPostingDate();
        postingFile = posting.getPostingFile();
        userNickName = posting.getUser().getUserNickName();
    }
}
