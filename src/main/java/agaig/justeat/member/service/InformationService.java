package agaig.justeat.member.service;

import agaig.justeat.member.domain.Information;
import agaig.justeat.member.dto.InfoResponseDto;
import agaig.justeat.member.dto.InfoSaveRequestDto;
import agaig.justeat.member.repository.InformationRepository;
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

    public List<Information> getBoardList() {
        return informationRepository.selectAll();
    }

    public Long getCount() {
        return informationRepository.count();
    }

    public Long remove(Long info_id, Long member_id) {
        return informationRepository.delete(info_id, member_id);
    }

    public Long write(InfoSaveRequestDto requestDto) {
        return informationRepository.insert(requestDto.toEntity());
    }

    public InfoResponseDto read(Long info_id) {
        Information information = informationRepository.select(info_id);
        InfoResponseDto responseDto = new InfoResponseDto(information);
        informationRepository.increaseViewCnt(info_id);
        return responseDto;
    }

    public List<Information> getPage(Map<String, Integer> map) {
        return informationRepository.selectPage(map);
    }
}
