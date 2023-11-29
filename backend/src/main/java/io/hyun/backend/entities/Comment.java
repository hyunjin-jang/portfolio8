package io.hyun.backend.entities;

import io.hyun.backend.entities.dto.commentDto.RequestCommentDto;
import io.hyun.backend.entities.dto.commentDto.RequestEditCommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentContent;
    private Timestamp commentDate;
    private Timestamp commentEditDate;
    @ManyToOne(fetch = LAZY)
    private User user;
    @ManyToOne(fetch = LAZY)
    private Posting posting;

    public Comment(RequestCommentDto dto) {
        commentContent = dto.getCommentContent();
    }

    public Comment(RequestEditCommentDto dto) {
        commentId = dto.getCommentId();
        commentContent = dto.getCommentContent();
        commentDate = dto.getCommentDate();
        commentEditDate = dto.getCommentEditDate();
        user = dto.getUser();
        posting = dto.getPosting();
    }

    public void setPosting(Posting posting) {
        this.posting = posting;
        posting.getCommentList().add(this);
    }

    public void setUser(User user) {
        this.user = user;
        user.getCommentList().add(this);
    }
}
