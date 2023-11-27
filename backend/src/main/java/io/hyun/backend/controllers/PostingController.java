package io.hyun.backend.controllers;

import io.hyun.backend.entities.dto.postDto.*;
import io.hyun.backend.services.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostingController {
    private final PostingService postingService;

    @PostMapping("/postings")
    public String writePosting(@RequestBody RequestPostingDto dto) {
        return postingService.createPosting(dto);
    }

    @GetMapping("/postings")
    public List<ResponsePostingDto> findAll() {
        return postingService.findAll();
    }

    @GetMapping("/postings/{userId}")
    public List<ResponseUserPostingDto> findUserPosting(@PathVariable Long userId) {
        return postingService.findByUser(userId);
    }

    @PutMapping("/postings/{postingId}")
    public ResponseEditPostingDto responseEditPosting(@PathVariable Long postingId) {
        return postingService.responseEditPosting(postingId);
    }

    @PutMapping("/postings")
    public void requestEditPosting(@RequestBody RequestEditPostingDto dto) {
        postingService.requestEditPosting(dto);
    }

    @DeleteMapping("/postings/{postingId}")
    public String deletePosting(@PathVariable Long postingId) {
        return postingService.deletePosting(postingId);
    }
}
