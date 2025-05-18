package kakaotechcampus.boardproject.controller;

import kakaotechcampus.boardproject.dto.CreatePostRequestDto;
import kakaotechcampus.boardproject.dto.PostResponseDto;
import kakaotechcampus.boardproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<PostResponseDto[]> findAll() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> save(@RequestBody CreatePostRequestDto requestDto) {

        return new ResponseEntity<>(postService.save(requestDto),HttpStatus.OK);
    }

}
