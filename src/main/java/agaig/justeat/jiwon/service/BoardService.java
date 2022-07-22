package agaig.justeat.jiwon.service;

import agaig.justeat.jiwon.domain.Articles;
import agaig.justeat.jiwon.domain.Comments;
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

    public List<Articles> findAll(){ return boardMapper.findAll();}

    public void create(Articles articles){ boardMapper.create(articles);}

    public Articles findOne(Long id){ return boardMapper.findOne(id);}

    public void deleteList(Long article_id){  boardMapper.deleteList(article_id);}

    public void update(Articles articles){ boardMapper.update(articles);}

    public void updateCnt(Long article_id){ boardMapper.updateCnt(article_id); }

    // 댓글 기능
    public List<Comments> findAllComments(Long id) { return boardMapper.findAllComments(id);}

    public void commentsWrite(Comments comments){ boardMapper.commentsWrite(comments);}

    public Comments findCommentsOne(Long id){ return boardMapper.findCommentsOne(id);}
}

