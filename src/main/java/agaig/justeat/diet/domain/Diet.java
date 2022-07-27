package agaig.justeat.diet.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Diet {
    private Long diet_id;
    private long monday;
    private long tuesday;
    private long wednesday;
    private long thursday;
    private long friday;
    private long saturday;
    private long sunday;

    public  Diet(Long diet_id, long monday, long tuesday, long wednesday, long thursday, long friday, long saturday, long sunday) {
        this.diet_id = diet_id;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }
}
