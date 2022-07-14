package agaig.justeat.jiwon.service;

import agaig.justeat.jiwon.domain.Articles;
import agaig.justeat.jiwon.model.aws.dao.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<Articles> findAll(){
        return boardMapper.findAll();
    }

    public void create(Articles articles){ boardMapper.create(articles);}

    public Articles findOne(Long id){ return boardMapper.findOne(id);  }

    public void deleteList(Long article_id){  boardMapper.deleteList(article_id);}

    //수정
//    public void update(Long article_id){ boardMapper.update(article_id);}

    public void update(Articles articles){ boardMapper.update(articles);}

}

