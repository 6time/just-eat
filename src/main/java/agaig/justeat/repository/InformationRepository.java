package agaig.justeat.repository;

import agaig.justeat.domain.Information;
import agaig.justeat.dto.InfoSaveRequestDto;
import agaig.justeat.dto.InfoUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface InformationRepository {

    Information select(Long info_id);

    Long insert(Information information);

    Long update(Information information);

    Long insert(InfoSaveRequestDto saveRequestDto);

    Long update(InfoUpdateRequestDto updateRequestDto);

    Long delete();

    List<Information> selectAll();

    List<Information> selectPage(Map<String, Integer> map);

    Long count();

    Long increaseViewCnt(Long info_id);

    Long deleteAll();
}
