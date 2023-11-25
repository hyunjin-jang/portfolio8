package io.hyun.backend.controllers;

import io.hyun.backend.entities.dto.commentDto.RequestCommentDto;
import io.hyun.backend.entities.dto.commentDto.RequestEditCommentDto;
import io.hyun.backend.entities.dto.commentDto.ResponseCommentDto;
import io.hyun.backend.entities.dto.commentDto.ResponseEditCommentDto;
import io.hyun.backend.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comments")
    public void writeComment(@RequestBody RequestCommentDto dto) {
        commentService.createComment(dto);
    }

    @GetMapping("/comments/{postingId}")
    public List<ResponseCommentDto> findPostingComment(@PathVariable Long postingId) {
        return commentService.findByPosting(postingId);
    }

    @GetMapping("/users/comments/{userId}")
    public List<ResponseCommentDto> findUserComment(@PathVariable Long userId) {
        return commentService.findByUser(userId);
    }

    @PutMapping("/comments/{commentId}")
    public ResponseEditCommentDto responseEditComment(@PathVariable Long commentId) {
        return commentService.responseEditComment(commentId);
    }

    @PutMapping("/comments")
    public void requestEditComment(@RequestBody RequestEditCommentDto dto) {
        commentService.requestEditComment(dto);
    }

    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }
}
