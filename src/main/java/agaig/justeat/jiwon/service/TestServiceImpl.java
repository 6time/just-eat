package agaig.justeat.jiwon.service;

import agaig.justeat.jiwon.model.aws.dao.TestMapper;
import agaig.justeat.jiwon.model.aws.dto.portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{
    private final TestMapper testMapper;

    @Override
    public List<portfolio> getAllDataList(){
        return testMapper.getAllDataList();
    }

}
