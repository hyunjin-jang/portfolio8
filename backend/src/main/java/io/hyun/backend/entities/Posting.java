package io.hyun.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private String postingDate;
    private String postingFile;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "posting")
    private List<Comment> comment = new ArrayList<>();
}
