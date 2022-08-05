package agaig.justeat.member.service;

import agaig.justeat.member.domain.Member;
import agaig.justeat.member.dto.MemberSaveRequestDto;
import agaig.justeat.member.dto.MemberUpdateResponseDto;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberServiceTest {

    private MemberService memberService;

    @Autowired
    public MemberServiceTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    void join() {
        // given
        MemberSaveRequestDto memberSaveRequestDto = new MemberSaveRequestDto();
        memberSaveRequestDto.setEmail("TEST");
        memberSaveRequestDto.setPassword("TEST");
        memberSaveRequestDto.setName("TEST");

        // when
        Long aLong = memberService.join(memberSaveRequestDto);

        // then
        MemberUpdateResponseDto responseDto = memberService.findInfoById(aLong);
        assertThat(memberSaveRequestDto.getEmail()).isEqualTo(responseDto.getEmail());
    }

    @Test
    void signIn() {
    }

    @Test
    void signInCheck() {
    }

    @Test
    void verify() {
    }

    @Test
    void passwordCheck() {
    }

    @Test
    void update() {
    }

    @Test
    void findInfoById() {
    }

    @Test
    void getAccessToken() {
    }

    @Test
    void getUserInfo() {
    }
}