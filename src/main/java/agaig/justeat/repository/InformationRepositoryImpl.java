//package agaig.justeat.repository;
//
//import agaig.justeat.dto.InfoBoardResponseDto;
//import agaig.justeat.dto.InfoResponseDto;
//import agaig.justeat.dto.InfoSaveRequestDto;
//import agaig.justeat.dto.InfoUpdateRequestDto;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class InformationRepositoryImpl implements InformationRepository{
//
//    @Autowired
//    SqlSession session;
//
//    String namespace = "agaig.justeat.repository.InformationRepository.";
//
//    @Override
//    public InfoResponseDto select(Long info_id) {
//        return session.selectOne(namespace+"select",3);
//    }
//
//    @Override
//    public List<InfoBoardResponseDto> selectPage(Map map) {
//        return null;
//    }
//
//    @Override
//    public List<InfoBoardResponseDto> selectAll() {
//        return null;
//    }
//
//    @Override
//    public Long insert(InfoSaveRequestDto saveRequestDto) {
//        return null;
//    }
//
//    @Override
//    public Long update(InfoUpdateRequestDto updateRequestDto) {
//        return null;
//    }
//
//    @Override
//    public Long delete() {
//        return null;
//    }
//
//    @Override
//    public Long deleteAll() {
//        return null;
//    }
//
//    @Override
//    public Long count() {
//        return null;
//    }
//
//    @Override
//    public Long increaseViewCnt(Long info_id) {
//        return null;
//    }
//}
