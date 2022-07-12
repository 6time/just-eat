package agaig.justeat.jiwon.model.aws.dao;

import agaig.justeat.jiwon.model.aws.dto.portfolio;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestMapper {
    List<portfolio> getAllDataList();


}
