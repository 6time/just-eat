package agaig.justeat.jiwon.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Articles {
    private Long article_id;
    private String article_title;
    private String article_text;
    private Long member_id;
    private String article_writer;
    private Timestamp article_time; //타임스탬프 추가
    private Long reNum; //조회수 증가

}
