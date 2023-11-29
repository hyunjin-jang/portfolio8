package io.hyun.backend.services;

import io.hyun.backend.entities.Posting;
import io.hyun.backend.entities.User;
import io.hyun.backend.entities.dto.postDto.*;
import io.hyun.backend.repositories.PostingRepository;
import io.hyun.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;
    private final UserRepository userRepository;

    public String createPosting(RequestPostingDto dto) {
        Posting posting = new Posting(dto);
        posting.setUser(dto.getUser());
        postingRepository.save(posting);
        return posting.getUser().getUserEmail()+"Success";
    }

    public List<ResponsePostingDto> findAll() {
        List<Posting> foundPosting = postingRepository.findAll();
        return foundPosting.stream()
                .map(ResponsePostingDto::new)
                .collect(Collectors.toList());
    }

    public List<ResponseUserPostingDto> findByUser(Long userId) {
        Optional<User> foundUser = userRepository.findById(userId);
        if (foundUser.isPresent()) {
            List<Posting> foundPosting = foundUser.get().getPostingList();
            return foundPosting.stream()
                    .map(ResponseUserPostingDto::new)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public ResponseEditPostingDto responseEditPosting(Long postingId) {
        Optional<Posting> foundPosting = postingRepository.findById(postingId);
        if(foundPosting.isPresent()) {
            return new ResponseEditPostingDto(foundPosting.get());
        }
        return null;
    }

    public void requestEditPosting(RequestEditPostingDto dto) {
        Posting result = new Posting(dto);
        System.out.println(dto.getEditPostingDate());
        postingRepository.save(result);
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
