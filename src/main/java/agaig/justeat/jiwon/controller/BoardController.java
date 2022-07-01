package agaig.justeat.jiwon.controller;

import agaig.justeat.jiwon.domain.Articles;
import agaig.justeat.jiwon.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardController {
    BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public String viewList() {
        Articles articles = new Articles();
        articles.setArticle_id(1L);
        articles.setArticle_text("test");
        articles.setArticle_title("TEST");
        boardService.test(articles);
        return "/board/list";
    }

    @GetMapping("/view/no")
    public String readArticle() {
        Long id = 1L;
        boardService.test2(id);
        return "/board/read";
    }

    @GetMapping("/write")
    public String writeArticle() {
        return "/board/write";
    }

    @GetMapping("/update")
    public String updateArticle() {
        return "/board/write/no";
    }

    @GetMapping("/delete")
    public String deleteArticle() {
        return "/board/list";
    }


}
