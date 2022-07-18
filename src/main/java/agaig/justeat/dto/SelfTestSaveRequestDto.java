package agaig.justeat.dto;

import agaig.justeat.domain.SelfTest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SelfTestSaveRequestDto { //DTO 계층 간에 데이터교환을 위한 객체

    private Long member_id;
    private int kcal;
    private int weight;
    private int exercise;

    @Builder //Builder pattern 이란 복합 객체의 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴
    public SelfTestSaveRequestDto(Long member_id, int kcal, int weight, int exercise) { //생성 과정
        this.member_id=member_id;
        this.kcal=kcal;
        this.weight=weight;
        this.exercise=exercise;
    }

    // SelfTestRequest DTO 로 받은 Member 객체를 Entity 화하여 저장하는 용도 / Client -> DB
    public SelfTest toEntity() { //builder 패턴을 통해 어떤 필드에 어떤 값을 넣어주는지 눈으로 확인 가능
        return SelfTest.builder()
                .kcal(kcal)
                .weight(weight)
                .exercise(exercise)
                .member_id(member_id)
                .build();
    }
}