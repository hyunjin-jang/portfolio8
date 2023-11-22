package io.hyun.backend.controllers;

import io.hyun.backend.entities.dto.RequestCommentDto;
import io.hyun.backend.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment")
    public void writeComment(@RequestBody RequestCommentDto dto) {
        commentService.createComment(dto);
    }
}
