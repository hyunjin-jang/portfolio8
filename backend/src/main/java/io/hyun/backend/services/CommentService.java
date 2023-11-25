package io.hyun.backend.services;

import io.hyun.backend.entities.Comment;
import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.User;
import io.hyun.backend.entities.dto.commentDto.*;
import io.hyun.backend.repositories.CommentRepository;
import io.hyun.backend.repositories.PostingRepository;
import io.hyun.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostingRepository postingRepository;
    private final UserRepository userRepository;

    public void createComment(RequestCommentDto dto) {
        Comment comment = new Comment(dto);
        comment.setPosting(dto.getPosting());
        comment.setUser(dto.getUser());
        commentRepository.save(comment);
    }

    public List<ResponseCommentDto> findByPosting(Long postingId) {
        Optional<Posting> foundPosting = postingRepository.findById(postingId);
        if(foundPosting.isPresent()) {
            List<Comment> foundComment = foundPosting.get().getCommentList();
            return foundComment.stream()
                    .map(c -> new ResponseCommentDto(c))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<ResponseCommentDto> findByUser(Long userId) {
        Optional<User> foundUser = userRepository.findById(userId);
        if(foundUser.isPresent()) {
            List<Comment> foundComment = foundUser.get().getCommentList();
            return foundComment.stream()
                    .map(c -> new ResponseCommentDto(c))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public ResponseEditCommentDto responseEditComment(Long commentId) {
        Optional<Comment> foundComment = commentRepository.findById(commentId);
        if(foundComment.isPresent()) {
            return new ResponseEditCommentDto(foundComment.get());
        }
        return null;
    }

    public void requestEditComment(RequestEditCommentDto dto) {
        Comment result = new Comment(dto);
        commentRepository.save(result);
    }

    public String deleteComment(Long commentId) {
        Optional<Comment> foundComment = commentRepository.findById(commentId);
        if(foundComment.isEmpty()){
            return "일치하는 댓글 없음";
        }
        commentRepository.deleteById(commentId);
        return "삭제했습니다.";
    }
}
