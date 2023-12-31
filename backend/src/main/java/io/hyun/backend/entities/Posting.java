package io.hyun.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hyun.backend.entities.dto.postDto.RequestEditPostingDto;
import io.hyun.backend.entities.dto.postDto.RequestPostingDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class Posting {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postingId;
    @Column(nullable = false, length = 100)
    private String postingTitle;
    @Lob
    private String postingContent;
    @ColumnDefault("0")
    private int count;
    @CreationTimestamp
    private Timestamp postingDate;
    @CreationTimestamp
    private Timestamp editPostingDate;
    private String postingFile;
    @ManyToOne(fetch = LAZY)
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "posting", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    public Posting(RequestPostingDto dto) {
        postingTitle = dto.getPostingTitle();
        postingContent = dto.getPostingContent();
        postingFile = dto.getPostingFile();
    }

    public Posting(RequestEditPostingDto dto) {
        postingId = dto.getPostingId();
        postingTitle = dto.getPostingTitle();
        postingContent = dto.getPostingContent();
        postingFile = dto.getPostingFile();
        editPostingDate = dto.getEditPostingDate();
        user = dto.getUser();
    }

    public void setUser(User user) {
        this.user = user;
        user.getPostingList().add(this);
    }
}
