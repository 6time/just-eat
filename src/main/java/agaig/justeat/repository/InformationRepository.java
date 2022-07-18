package agaig.justeat.repository;

import agaig.justeat.dto.InfoBoardResponseDto;
import agaig.justeat.dto.InfoResponseDto;
import agaig.justeat.dto.InfoSaveRequestDto;
import agaig.justeat.dto.InfoUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InformationRepository {
    InfoResponseDto select(Long info_id);

    Long insert(InfoSaveRequestDto saveRequestDto);

    Long update(InfoUpdateRequestDto updateRequestDto);

    Long delete();

    List<InfoBoardResponseDto> selectAll();

    List<InfoBoardResponseDto> selectPage(Map<String, Integer> map);

    Long count();

    Long increaseViewCnt(Long info_id);

    Long deleteAll();
}
