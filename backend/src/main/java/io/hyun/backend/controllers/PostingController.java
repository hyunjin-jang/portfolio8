package io.hyun.backend.controllers;

import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.dto.RequestPostingDto;
import io.hyun.backend.services.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostingController {
    private final PostingService postingService;

    @PostMapping("/postings")
    public String writePosting(@RequestBody RequestPostingDto dto) {
        return postingService.createPosting(dto);
    }

    @GetMapping("/postings/{userId}")
    public List<String> findUserPosting(@PathVariable Long userId) {
        return postingService.findByUser(userId);
    }

    @DeleteMapping("/postings/{postingId}")
    public String deletePosting(@PathVariable Long postingId) {
        return postingService.deletePosting(postingId);
    }
}
