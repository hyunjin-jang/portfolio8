package io.hyun.backend.services;

import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.User;
import io.hyun.backend.entities.dto.RequestPostingDto;
import io.hyun.backend.repositories.PostingRepository;
import io.hyun.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;
    private final UserRepository userRepository;

    public String createPosting(RequestPostingDto dto) {
        User user = dto.getUser();

        Posting posting = Posting.builder()
                .postingTitle(dto.getPostingTitle())
                .postingContent(dto.getPostingContent())
                .postingFile(dto.getPostingFile())
                .user(dto.getUser())
                .build();
        user.addPosting(posting);
        postingRepository.save(posting);
        return "Success";
    }
}
