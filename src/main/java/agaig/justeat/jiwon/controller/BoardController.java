package agaig.justeat.jiwon.controller;

import agaig.justeat.jiwon.domain.Articles;
import agaig.justeat.jiwon.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public String List(Model model){ // 외부 호출 메서드명과 상관 없음
        List<Articles> articles = boardService.findAll();
        model.addAttribute("Articles", articles);
        return "board/list";
    }

    @GetMapping("write")
    public String writeArticle(){
        return "board/write";
    }

    @PostMapping("write") // 수정 ("")
    public String create(Articles articles){


       boardService.create(articles);

        return "redirect:/boards"; // "redirect:/boards"
    }

        @GetMapping("/view/{article_id}")
    public String viewId(@PathVariable Long article_id, Model model) {
        Articles article = boardService.findOne(article_id);

        model.addAttribute("Article", article);

        return "board/read";
    }


        @GetMapping("/view/{article_id}/delete")
    public String delete(@PathVariable Long article_id){
        boardService.deleteList(article_id);
        return "redirect:/boards";
    }

    @GetMapping("/view/{article_id}/update")
    public String updateForm(@PathVariable Long article_id,Model model){
      Articles article = boardService.findOne(article_id);
      model.addAttribute("Article", article);
        return "board/update";
    }




//    @PostMapping("/view/{article_id}/update_action")
//    public String update(@PathVariable Long article_id,Model model){
//        Articles article = boardService.findOne(article_id);
//        boardService.update(article);
//        model.addAttribute("Article", article);
//        return "redirect:/boards";
//    }

    @PostMapping("/view/{article_id}/update")
    public String update(Articles articles){
        boardService.update(articles);

        return "redirect:/boards";
    }
















//    @GetMapping("")
//    public String list(Model model) {
//       List<Articles> articles = boardService.findList();
//       model.addAttribute("Articles", articles);
//
//        return "/board/list";
//    }
//
//    @GetMapping("/view/no")
//    public String readArticle() {
//        Long id = 1L;
//        boardService.findOne(id);
//        return "/board/read";
//    }
//
//    @GetMapping("/write")
//    public String writeArticle() {
//        return "/board/write";
//    }
//
//    @GetMapping("/update")
//    public String updateArticle() {
//        return "/board/write/no";
//    }
//
//    @GetMapping("/delete")
//    public String deleteArticle() {
//        return "/board/list";
//    }
//
//
//    //BoardForm
//    @PostMapping("")
//    public String create(BoardForm form){
//        Articles articles = new Articles();
//        articles.setArticle_title(form.getArticle_title());
//        articles.setArticle_text(form.getArticle_text());
//
//        boardService.join(articles);
//
//        return "redirect:/boards";
//    }
//
//    @GetMapping("/view/{article_id}")
//    public String viewId(@PathVariable Long article_id, Model model) {
//        Articles article = boardService.findOne(article_id);
//
//        model.addAttribute("Article", article);
//
//        return "board/read";
//    }
//
//    @GetMapping("/view/{article_id}/delete")
//    public String delete(@PathVariable Long article_id){
//        boardService.deleteList(article_id);
//        return "board/list";
//    }



}



