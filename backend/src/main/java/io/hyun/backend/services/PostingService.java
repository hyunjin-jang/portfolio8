package io.hyun.backend.services;

import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.User;
import io.hyun.backend.entities.dto.RequestPostingDto;
import io.hyun.backend.repositories.PostingRepository;
import io.hyun.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;
    private final UserRepository userRepository;

    public String createPosting(RequestPostingDto dto) {
        Posting posting = Posting.builder()
                .postingTitle(dto.getPostingTitle())
                .postingContent(dto.getPostingContent())
                .postingFile(dto.getPostingFile())
                .build();
        posting.setUser(dto.getUser());
        postingRepository.save(posting);
        return "Success";
    }

    public List<String> findByUser(Long userId) {
        Optional<User> foundUser = userRepository.findById(userId);
        if (foundUser.isPresent()) {
            User user = foundUser.get();
            List<String> postingTitles = new ArrayList<>();
            for(Posting posting : user.getPostingList()){
                postingTitles.add(posting.getPostingTitle());
            }
            return postingTitles;
        }
        return null;
    }

    public String deletePosting(Long postingId) {
        Optional<Posting> foundPosting = postingRepository.findById(postingId);
        if(foundPosting.isEmpty()){
            return "일치하는 포스팅 없음";
        }
        postingRepository.deleteById(postingId);
        return "삭제했습니다.";
    }
}
