package kakaotechcampus.boardproject.service;

import kakaotechcampus.boardproject.dto.MemberResponseDto;
import kakaotechcampus.boardproject.dto.SignUpRequestDto;
import kakaotechcampus.boardproject.dto.SignUpResponseDto;
import kakaotechcampus.boardproject.entity.Member;
import kakaotechcampus.boardproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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

    public MemberResponseDto findById(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        if (member.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        return new MemberResponseDto(member.get().getUsername(), member.get().getAge());
    }
}
