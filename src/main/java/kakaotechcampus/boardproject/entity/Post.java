package kakaotechcampus.boardproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "post")
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String content;

    @Setter
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
