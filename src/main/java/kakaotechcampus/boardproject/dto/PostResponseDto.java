package kakaotechcampus.boardproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostResponseDto {

    private Long id;

    private String title;

    private String content;
}
