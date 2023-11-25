package io.hyun.backend.entities.dto.commentDto;

import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCommentDto {
    private String commentContent;
    private Posting posting;
    private User user;
}
