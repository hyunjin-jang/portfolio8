package io.hyun.backend.entities.dto;

import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCommentDto {
    private String commentContent;
    private String commentDate;
    private User user;
    private Posting posting;
}
