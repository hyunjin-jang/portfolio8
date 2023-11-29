package io.hyun.backend.entities.dto.postDto;

import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class RequestEditPostingDto {
    private Long postingId;
    private String postingTitle;
    private String postingContent;
    private String postingFile;
    private Timestamp editPostingDate;
    private User user;
}
