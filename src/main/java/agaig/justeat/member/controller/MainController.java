package agaig.justeat.member.controller;

import agaig.justeat.member.annotation.MemberSignInCheck;
import agaig.justeat.member.dto.MemberUpdateResponseDto;
import agaig.justeat.member.exception.SignInException;
import agaig.justeat.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberService memberService;

    @GetMapping("")
    public String main(Model model, HttpSession session) {
        Object member_id = Optional.ofNullable(session.getAttribute("session")).orElse("회원");
        if (member_id == "회원") {
            model.addAttribute("memberName", member_id);
            return "index";
        }
        MemberUpdateResponseDto responseDto = memberService.findInfoById((Long) member_id);
        model.addAttribute("memberName", responseDto.getName());
        return "index";
    }

//    @MemberSignInCheck
//    @GetMapping("/selflogin")
//    public String self() {
//        return "/selftest/SelfTestFoundation";
//    }

    @MemberSignInCheck
    @GetMapping("/healthlogin")
    public String health() {
        return "/health/healthTest";
    }


    @ExceptionHandler(SignInException.class)
    public String loginCatcher(Exception e, HttpServletRequest request) {
        return "redirect:/members/?toURL=" + request.getRequestURL();

    }
}
