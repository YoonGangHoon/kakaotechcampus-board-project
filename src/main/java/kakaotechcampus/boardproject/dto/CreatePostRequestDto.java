package kakaotechcampus.boardproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePostRequestDto {

    private String title;

    private String content;

    private String username;
}
