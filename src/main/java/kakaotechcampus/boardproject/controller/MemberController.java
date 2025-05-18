package kakaotechcampus.boardproject.controller;

import kakaotechcampus.boardproject.dto.MemberResponseDto;
import kakaotechcampus.boardproject.dto.SignUpRequestDto;
import kakaotechcampus.boardproject.dto.SignUpResponseDto;
import kakaotechcampus.boardproject.dto.UpdatePasswordRequestDto;
import kakaotechcampus.boardproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {

        return new ResponseEntity<>(memberService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
        SignUpResponseDto signUpResponseDto = memberService.signUp(requestDto);

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UpdatePasswordRequestDto requestDto) {
        memberService.updatePassword(id, requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
