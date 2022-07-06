package agaig.justeat.jiwon.controller;

import agaig.justeat.jiwon.domain.Articles;
import agaig.justeat.jiwon.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {
    BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public String list(Model model) {
       List<Articles> articles = boardService.findList();
       model.addAttribute("Articles", articles);

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


    //BoardForm
    @PostMapping("")
    public String create(BoardForm form){
        Articles articles = new Articles();
        articles.setArticle_title(form.getArticle_title());
        articles.setArticle_text(form.getArticle_text());

        boardService.join(articles);

        return "redirect:/boards";
    }


}



