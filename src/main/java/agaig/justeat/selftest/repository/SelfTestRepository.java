package agaig.justeat.selftest.repository;

import agaig.justeat.selftest.domain.SelfTest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //repository 구현체가 없는 이유: Mybatis에서 구현체에서 할 일을 대신하기 때문
public interface SelfTestRepository {
//    Long update(SelfTest selfTest); //숫자형만 가능 Long
    Long save(SelfTest selfTest);
    List<SelfTest> findById(Long member_id);

}