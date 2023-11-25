package io.hyun.backend.entities.dto.commentDto;

import io.hyun.backend.entities.Comment;
import io.hyun.backend.entities.dto.postDto.ResponseEditPostingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEditCommentDto {
    private String commentContent;

    public ResponseEditCommentDto(Comment comment) {
        commentContent = comment.getCommentContent();
    }
}
