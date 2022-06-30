package agaig.justeat.service;

import agaig.justeat.domain.Member;
import agaig.justeat.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        Optional<Member> byEmail = memberRepository.findByEmail(member.getEmail());
        return byEmail.orElse(member).getMember_id();
    }
}
