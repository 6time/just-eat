package agaig.justeat.selftest.repository;

import agaig.justeat.selftest.domain.SelfTest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelfTestRepository {

    Long save(SelfTest selfTest); //숫자형만 가능 Long
    List<SelfTest> findById(Long member_id);

}