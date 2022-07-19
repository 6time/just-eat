package agaig.justeat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Member {
    private Long member_id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String gender;
    private String birth;

    @Builder
    public Member(Long member_id, String email, String password, String name, String phone, String address, String gender, String birth) {
        this.member_id = member_id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.birth = birth;
    }
}