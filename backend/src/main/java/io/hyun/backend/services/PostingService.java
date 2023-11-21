package io.hyun.backend.services;

import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.dto.RequestPostingDto;
import io.hyun.backend.repositories.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;

    public void createPosting(RequestPostingDto dto) {
        Posting posting = Posting.builder()
                .postingTitle(dto.getPostingTitle())
                .postingContent(dto.getPostingContent())
                .postingFile(dto.getPostingFile())
                .postingDate(dto.getPostingDate())
                .user(dto.getUser())
                .build();
        postingRepository.save(posting);
    }
}
