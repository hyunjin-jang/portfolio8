package io.hyun.backend.services;

import io.hyun.backend.entities.Comment;
import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.dto.RequestCommentDto;
import io.hyun.backend.entities.dto.RequestPostingDto;
import io.hyun.backend.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void createComment(RequestCommentDto dto) {
        Comment comment = Comment.builder()
                .commentContent(dto.getCommentContent())
                .commentDate(dto.getCommentDate())
                .user(dto.getUser())
                .posting(dto.getPosting())
                .build();
        commentRepository.save(comment);
    }
}
