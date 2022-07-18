package agaig.justeat.service;

import agaig.justeat.domain.Member;
import agaig.justeat.dto.MemberResponseDto;
import agaig.justeat.dto.MemberSaveRequestDto;
import agaig.justeat.repository.MemberRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(MemberSaveRequestDto requestDto) {
        Optional.ofNullable(memberRepository.findByEmail(requestDto.getEmail()))
                .ifPresent((member -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                }));
        return memberRepository.save(requestDto.toEntity());
    }

    public MemberResponseDto signIn(String email, String password) {
        Member member = Optional.ofNullable(memberRepository.findByEmail(email)).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원 입니다."));
        MemberResponseDto responseDto = new MemberResponseDto(member);
        if (!password.equals(member.getPassword())) {
            throw new IllegalStateException("틀린 비밀번호 입니다.");
        }
        return responseDto;
    }

    public void signInCheck(HttpSession session) {
        Optional.ofNullable(session.getAttribute("session"))
                .orElseThrow(() ->
                        new IllegalStateException("로그인이 필요합니다."));
    }
}
