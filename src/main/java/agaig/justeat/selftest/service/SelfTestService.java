package agaig.justeat.selftest.service;

import agaig.justeat.selftest.domain.SelfTest;
import agaig.justeat.selftest.repository.SelfTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfTestService { //service는 프레젠테이션(뷰)에서 직접 엔티티에 접근하지 않고, 비즈니스 로직을 처리할 수 있도록하는 계층
                               //Repository에 정의된 비즈니스 로직을 처리하거나 직접 엔티티에 접근
    private final SelfTestRepository selfTestRepository;

    @Autowired //필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입
    public SelfTestService(SelfTestRepository selfTestRepository) {
        this.selfTestRepository = selfTestRepository;
    }

    public Long save(SelfTest selfTest) {
        return selfTestRepository.save(selfTest);
    }

    public List<SelfTest> findMembers(Long member_id) {
        return selfTestRepository.findById(member_id);
    }
}

