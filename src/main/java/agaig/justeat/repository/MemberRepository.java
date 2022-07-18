package agaig.justeat.repository;

import agaig.justeat.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MemberRepository {
    Long save(Member member);

    Member update(Member member);

//    Optional<Member> findById(Long id);

    Member findByEmail(String email);

//    List<Member> findAll();
}
