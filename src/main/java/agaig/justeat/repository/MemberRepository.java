package agaig.justeat.repository;

import agaig.justeat.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface MemberRepository {

    Long insert(Member member);

    Long update(Member member);

    Member findById(Long id);

    Member findByEmail(String email);

    List<Member> findAll();
}
