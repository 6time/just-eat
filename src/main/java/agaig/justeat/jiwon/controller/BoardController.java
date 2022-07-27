package agaig.justeat.jiwon.controller;


import agaig.justeat.jiwon.domain.Articles;
import agaig.justeat.jiwon.domain.Comments;
import agaig.justeat.jiwon.service.BoardService;
import agaig.justeat.member.annotation.MemberSignInCheck;
import agaig.justeat.member.domain.Member;
import agaig.justeat.member.dto.MemberUpdateResponseDto;
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
    public String List(Model model) {
        List<Articles> articles = boardService.findAll();
        model.addAttribute("Articles", articles); //boardService.getListPaging(cri) -> articles

        return "board/list";
    }

    @GetMapping("write")
    public String writeArticle(HttpSession session, Member member,Model model) {
        try {
            memberService.signInCheck(session);
        } catch (Exception e) {
            return "/member/signIn";
        }
        MemberUpdateResponseDto responseDto = memberService.findInfoById((Long) session.getAttribute("session"));
        model.addAttribute("Member", responseDto);
        return "board/write";
    }

    @PostMapping("write")
    public String create(Articles articles, HttpSession session, Member member) { //HttpSession session 추가
//        MemberUpdateResponseDto memberResponseDto = (MemberUpdateResponseDto) session.getAttribute("session");
//        articles.setArticle_writer();
        MemberUpdateResponseDto responseDto = memberService.findInfoById((Long) session.getAttribute("session"));
        articles.setMember_id(responseDto.getMember_id()); // 이상있으면 바로 삭제해야 할 추가
        articles.setArticle_writer(responseDto.getName());
        boardService.create(articles);

        return "redirect:/boards";
    }

    @GetMapping("/view/{article_id}")
    public String viewId(@PathVariable Long article_id, Model model,HttpSession session) { //Long reNum 문제시 삭제
        Articles article = boardService.findOne(article_id);
        boardService.updateCnt(article_id);
        model.addAttribute("Article", article);
        List<Comments> comments = boardService.findAllComments(article_id);// 댓글 기능
        model.addAttribute("Comments", comments); // 댓글 기능
        MemberUpdateResponseDto responseDto = memberService.findInfoById((Long) session.getAttribute("session"));
        model.addAttribute("Member", responseDto);
        return "board/read";
    }

    //댓글 기능
    @MemberSignInCheck
    @PostMapping("/view/{article_id}/commentsWrite")
    public String commentsWrite(@PathVariable Long article_id, HttpSession session,Comments comments){
//        MemberUpdateResponseDto memberResponseDto = (MemberUpdateResponseDto) session.getAttribute("session");
//        Comments comments = boardService.findCommentsOne(article_id);
        MemberUpdateResponseDto responseDto = memberService.findInfoById((Long) session.getAttribute("session"));
        comments.setComment_writer(responseDto.getName());
        comments.setMember_id(responseDto.getMember_id());
        comments.setArticle_id(article_id);
        boardService.commentsWrite(comments);
        return "redirect:/boards/view/{article_id}";
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


}



