package agaig.justeat.selftest.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class SelfTest {

    private String name;
    private Long member_id;
    private int daykcal;
    private int dayweight;
    private int dayexercise;
    
    private String regDate;

    @Builder
    public SelfTest(Long member_id, int daykcal, int dayweight, int dayexercise, String name, String regDate) {
        this.member_id=member_id;
        this.daykcal=daykcal;
        this.dayweight=dayweight;
        this.dayexercise=dayexercise;
        this.name=name;
        this.regDate=regDate;
    }
}