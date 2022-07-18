package agaig.justeat.service;

import agaig.justeat.dto.InfoBoardResponseDto;
import agaig.justeat.dto.InfoResponseDto;
import agaig.justeat.dto.InfoSaveRequestDto;
import agaig.justeat.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InformationService {
    private final InformationRepository informationRepository;

    @Autowired
    public InformationService(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    public List<InfoBoardResponseDto> getBoardList() {
        return informationRepository.selectAll();
    }

    public Long getCount() {
        return informationRepository.count();
    }

    public Long remove(Long info_id, String writer) {
        return informationRepository.delete();
    }

    public Long write(InfoSaveRequestDto requestDto) {
        return informationRepository.insert(requestDto);
    }

    public InfoResponseDto read(Long info_id) {
        InfoResponseDto responseDto = informationRepository.select(info_id);
        informationRepository.increaseViewCnt(info_id);
        return responseDto;
    }

    public List<InfoBoardResponseDto> getPage(Map<String, Integer> map) {
        return informationRepository.selectPage(map);
    }
}
