package io.hyun.backend.controllers;

import io.hyun.backend.entities.dto.RequestPostingDto;
import io.hyun.backend.services.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostingController {
    private final PostingService postingService;

    @PostMapping("/posting")
    public void writePosting(@RequestBody RequestPostingDto dto) {
        postingService.createPosting(dto);
    }
}
