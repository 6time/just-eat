package agaig.justeat.jiwon.service;

import agaig.justeat.jiwon.domain.Articles;
import agaig.justeat.jiwon.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void test2(Long id){
        boardRepository.findById(id);
    }
}
