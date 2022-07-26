package agaig.justeat.member.service;

import agaig.justeat.member.domain.Member;
import agaig.justeat.member.dto.MemberUpdateResponseDto;
import agaig.justeat.member.dto.MemberSaveRequestDto;
import agaig.justeat.member.dto.MemberUpdateRequestDto;
import agaig.justeat.member.exception.ErrorCode;
import agaig.justeat.member.exception.SignInException;
import agaig.justeat.member.repository.MemberRepository;
import agaig.justeat.member.util.MemberSha256;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(MemberSaveRequestDto requestDto) {
        Optional.ofNullable(memberRepository.findByEmail(requestDto.getEmail()))
                .ifPresent((member -> {
                    throw new SignInException("이미 존재하는 회원입니다.", ErrorCode.ADMIN_NOT_FOUND);
                }));
        requestDto.setPassword(MemberSha256.encrypt(requestDto.getPassword()));
        return memberRepository.insert(requestDto.toEntity());
    }

    public Long signIn(String email, String password) {
        Member member = Optional.ofNullable(memberRepository.findByEmail(email)).orElseThrow(() -> new SignInException("존재하지 않는 회원 입니다.", ErrorCode.ADMIN_NOT_FOUND));
        String encryptPassword = MemberSha256.encrypt(password);
        if (!encryptPassword.equals(member.getPassword())) {
            throw new SignInException("틀린 비밀번호 입니다.", ErrorCode.ADMIN_NOT_FOUND);
        }
        return member.getMember_id();
    }

    public void signInCheck(HttpSession session) {
        Optional.ofNullable(session.getAttribute("session"))
                .orElseThrow(() ->
                        new SignInException("로그인이 필요합니다.", ErrorCode.ADMIN_NOT_FOUND));
    }

    public void verify(Long member_id, HttpSession session) {
        if (!member_id.equals(session.getAttribute("session"))) {
            throw new SignInException("잘못된 접근입니다.", ErrorCode.ADMIN_NOT_FOUND);
        }
    }

    public void passwordCheck(Long member_id, String password) {
        Member member = memberRepository.findById(member_id);
        if (!password.equals(member.getPassword())) {
            throw new SignInException("틀린 비밀번호 입니다.", ErrorCode.ADMIN_NOT_FOUND);
        }
    }

    public Long update(Long member_id, MemberUpdateRequestDto requestDto) {
        requestDto.setMember_id(member_id);
        return memberRepository.update(requestDto.toEntity());
    }

    public MemberUpdateResponseDto findInfoById(Long member_id) {
        Member member = Optional.ofNullable(memberRepository.findById(member_id)).orElseThrow(()->new SignInException("존재하지 않는 회원 입니다.", ErrorCode.ADMIN_NOT_FOUND));
        return new MemberUpdateResponseDto(member);
    }
}
