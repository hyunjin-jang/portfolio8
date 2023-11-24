package io.hyun.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posting {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postingId;
    private String postingTitle;
    private String postingContent;
    private LocalDateTime postingDate;
    private String postingFile;
    @ManyToOne(fetch = LAZY)
    private User user;
    @OneToMany(mappedBy = "posting")
    private List<Comment> commentList = new ArrayList<>();

    public void setUser(User user) {
        this.user = user;
        user.getPostingList().add(this);
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
        comment.setPosting(this);
    }
}
