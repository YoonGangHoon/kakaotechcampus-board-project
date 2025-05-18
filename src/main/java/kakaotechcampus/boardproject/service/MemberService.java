package kakaotechcampus.boardproject.service;

import kakaotechcampus.boardproject.dto.SignUpRequestDto;
import kakaotechcampus.boardproject.dto.SignUpResponseDto;
import kakaotechcampus.boardproject.entity.Member;
import kakaotechcampus.boardproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {

        Member member = new Member(
                signUpRequestDto.getUsername(),
                signUpRequestDto.getPassword(),
                signUpRequestDto.getAge()
        );

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getUsername(),
                                    savedMember.getPassword(),
                                    savedMember.getAge()
        );
    }
}
