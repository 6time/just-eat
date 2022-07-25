package agaig.justeat.selftest.repository;

import agaig.justeat.selftest.domain.SelfTest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemorySelfTestRepository implements SelfTestRepository{
    @Autowired
    SqlSession sqlSession;
    @Override
    public Long save(SelfTest selfTest) {
        return null;
    }

    @Override
    public List<SelfTest> findById(Long member_id) {
        return sqlSession.selectList("mapper.SelfTestMapper.findById");
    }
}
