package agaig.justeat.jiwon.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Articles {
    private Long article_id;
    private String article_title;
    private String article_text;
    private Long member_id;


}
