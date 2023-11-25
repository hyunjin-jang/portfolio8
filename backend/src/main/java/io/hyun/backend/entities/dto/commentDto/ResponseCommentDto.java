package io.hyun.backend.entities.dto.commentDto;

import io.hyun.backend.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCommentDto {
    private String commentContent;
    private LocalDateTime commentDate;
    private String userNickName;

    public ResponseCommentDto(Comment comment) {
        commentContent = comment.getCommentContent();
        commentDate = comment.getCommentDate();
        userNickName = comment.getUser().getUserNickName();
    }
}
