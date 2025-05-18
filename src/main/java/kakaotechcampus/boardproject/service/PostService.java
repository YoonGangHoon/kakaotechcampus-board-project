package kakaotechcampus.boardproject.service;

import kakaotechcampus.boardproject.dto.CreatePostRequestDto;
import kakaotechcampus.boardproject.dto.PostResponseDto;
import kakaotechcampus.boardproject.entity.Member;
import kakaotechcampus.boardproject.entity.Post;
import kakaotechcampus.boardproject.repository.MemberRepository;
import kakaotechcampus.boardproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public PostResponseDto save(CreatePostRequestDto requestDto) {

        Member member = memberRepository.findByUsernameOrElseThrow(requestDto.getUsername());

        Post post = new Post(requestDto.getTitle(), requestDto.getContent());
        post.setMember(member);

        postRepository.save(post);

        return new PostResponseDto(post.getId(), post.getTitle(), post.getContent());
    }

    public PostResponseDto[] findAll() {
        return postRepository.findAll().stream()
                .map(post -> new PostResponseDto(post.getId(), post.getTitle(), post.getContent()))
                .toArray(PostResponseDto[]::new);
    }

    public PostResponseDto findById(Long id) {
        return postRepository.findById(id)
                .map(post -> new PostResponseDto(post.getId(), post.getTitle(), post.getContent()))
                .orElseThrow(() -> new IllegalArgumentException("Not found id = " + id));
    }
}
