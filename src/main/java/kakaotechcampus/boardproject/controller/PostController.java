package kakaotechcampus.boardproject.controller;

import kakaotechcampus.boardproject.dto.CreatePostRequestDto;
import kakaotechcampus.boardproject.dto.PostResponseDto;
import kakaotechcampus.boardproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDto> save(@RequestBody CreatePostRequestDto requestDto) {

        return new ResponseEntity<>(postService.save(requestDto),HttpStatus.OK);
    }

}
