package agaig.justeat.jiwon.service;

import agaig.justeat.jiwon.domain.Articles;
import agaig.justeat.jiwon.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void test(Articles articles) {
        boardRepository.save(articles);
    }

    public Articles findOne(Long id){
      return boardRepository.findById(id);

    }

    public Long join(Articles articles){
        boardRepository.save(articles);
        return articles.getArticle_id();
    }

    public List<Articles> findList() {
        return boardRepository.findAll();
    }

    public void deleteList(Long article_id){
        boardRepository.delete(article_id);
    }

}

// 1. 데이터베이스 연결 2. jstl forEach를 이용한 반복문 작성 3. jsp를 통한 게시판 틀 작성