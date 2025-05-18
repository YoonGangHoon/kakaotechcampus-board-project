package kakaotechcampus.boardproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpResponseDto {

    private String username;

    private String password;

    private Integer age;
}
