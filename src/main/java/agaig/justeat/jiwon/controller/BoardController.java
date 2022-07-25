package agaig.justeat.jiwon.controller;

import agaig.justeat.member.annotation.MemberSignInCheck;
import agaig.justeat.member.dto.MemberUpdateResponseDto;
import agaig.justeat.jiwon.domain.Articles;
import agaig.justeat.jiwon.service.BoardService;
import agaig.justeat.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {
    BoardService boardService;
    MemberService memberService;

    public BoardController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberService = memberService;
    }

    @GetMapping("")
    public String List(Model model) { // Criteria cri 제거
        List<Articles> articles = boardService.findAll();
        model.addAttribute("Articles", articles); //boardService.getListPaging(cri) -> articles


        return "board/list";
    }

    @GetMapping("write")
    public String writeArticle(HttpSession session) {
        try {
            memberService.signInCheck(session);
        } catch (Exception e) {
            return "/member/signIn";
        }
        return "board/write";
    }

    @PostMapping("write")
    public String create(Articles articles, HttpSession session) { //HttpSession session 추가
        MemberUpdateResponseDto memberResponseDto = (MemberUpdateResponseDto) session.getAttribute("session"); // 추가
        articles.setArticle_writer(memberResponseDto.getName()); //추가
        articles.setMember_id(memberResponseDto.getMember_id()); // 이상있으면 바로 삭제해야 할 추가
        System.out.println(articles.getArticle_writer()); // 추가
        boardService.create(articles);

        return "redirect:/boards";
    }

    @GetMapping("/view/{article_id}")
    public String viewId(@PathVariable Long article_id, Model model) {
        Articles article = boardService.findOne(article_id);

        model.addAttribute("Article", article);

        return "board/read";
    }

    @MemberSignInCheck
    @GetMapping("/view/{article_id}/delete")
    public String delete(@PathVariable Long article_id, HttpSession session) {
        Articles articles = boardService.findOne(article_id);
        memberService.verify(articles.getMember_id(), session);
        boardService.deleteList(article_id);
        return "redirect:/boards";
    }

    @MemberSignInCheck
    @GetMapping("/view/{article_id}/update")
    public String updateForm(@PathVariable Long article_id, Model model, HttpSession session) {
        Articles article = boardService.findOne(article_id);
        memberService.verify(article.getMember_id(), session);
        model.addAttribute("Article", article);
        return "board/update";
    }

    @MemberSignInCheck
    @PostMapping("/view/{article_id}/update")
    public String update(Articles articles, HttpSession session) {
        Articles article = boardService.findOne(articles.getArticle_id());
        memberService.verify(article.getMember_id(), session);
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



