//package agaig.justeat.repository;
//
//import agaig.justeat.domain.Member;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class MemberRepositoryIml implements MemberRepository {
//
//    @Autowired
//    SqlSession session;
//
//    String namespace = "agaig.justeat.repository.MemberRepository.";
//    @Override
//    public Long save(Member member) {
//        return null;
//    }
//
//    @Override
//    public Member update(Member member) {
//        return null;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Member findByEmail(String email) {
//        return null;
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return null;
//    }
//}
