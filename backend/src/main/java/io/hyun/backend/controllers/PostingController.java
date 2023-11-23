package io.hyun.backend.controllers;

import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.dto.RequestPostingDto;
import io.hyun.backend.services.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostingController {
    private final PostingService postingService;

    @PostMapping("/posting")
    public String writePosting(@RequestBody RequestPostingDto dto) {
        return postingService.createPosting(dto);
    }
}
