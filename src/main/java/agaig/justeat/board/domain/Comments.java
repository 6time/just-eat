package agaig.justeat.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    private Long comment_id;
    private String comment_text;
    private Long member_id;
    private Long article_id;
    private String comment_writer;


}
