package io.hyun.backend.entities.dto;

import io.hyun.backend.entities.Posting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEditPostingDto {
    private String postingTitle;
    private String postingContent;
    private String postingFile;

    public ResponseEditPostingDto(Posting posting) {
        postingTitle = posting.getPostingTitle();
        postingContent = posting.getPostingContent();
        postingFile = posting.getPostingFile();
    }
}
