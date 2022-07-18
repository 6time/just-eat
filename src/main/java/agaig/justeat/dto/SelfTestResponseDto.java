/*package agaig.justeat.dto;

import agaig.justeat.domain.SelfTest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SelfTestResponseDto {

    private int kcal;
    private int weight;
    private int exercise;
    private Long member_id;

    // repository 를 통해 조회한 Entity 를 DTO 로 변환 용도 DB -> Client
    public SelfTestResponseDto(SelfTest selfTest) {
        this.kcal = selfTest.getKcal();
        this.weight = selfTest.getWeight();
        this.exercise= selfTest.getExercise();
        this.member_id= selfTest.getMember_id();
    }
}*/