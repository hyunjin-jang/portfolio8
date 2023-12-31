package io.hyun.backend.entities.dto.commentDto;

import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestEditCommentDto {
    private Long commentId;
    private String commentContent;
    private Timestamp commentDate;
    private Timestamp commentEditDate;
    private Posting posting;
    private User user;
}
