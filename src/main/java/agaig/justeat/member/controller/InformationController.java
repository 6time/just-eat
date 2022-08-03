package agaig.justeat.member.controller;

import agaig.justeat.member.annotation.MemberSignInCheck;
import agaig.justeat.member.domain.Information;
import agaig.justeat.member.domain.PageHandler;
import agaig.justeat.member.dto.InfoResponseDto;
import agaig.justeat.member.dto.InfoSaveRequestDto;
import agaig.justeat.member.dto.InfoUpdateRequestDto;
import agaig.justeat.member.dto.MemberUpdateResponseDto;
import agaig.justeat.member.service.InformationService;
import agaig.justeat.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/info")
public class InformationController {

    private final InformationService informationService;
    private final MemberService memberService;

    @GetMapping("/list")
    public String list(Integer page, Integer pageSize, Model model) {
        if (page == null) page = 1;
        if (pageSize == null) pageSize = 10;
        long totalCnt = informationService.getCount();
        PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);
        Map<String, Integer> map = new HashMap<>();
        map.put("offset", (page - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<Information> boardList = informationService.getPage(map);
        model.addAttribute("infoBoardList", boardList);
        model.addAttribute("pageHandler", pageHandler);
        model.addAttribute(page);
        model.addAttribute(pageSize);
        return "information/infoList";
    }

    @GetMapping("/{info_id}")
    public String infoRead(@PathVariable Long info_id, Integer page, Integer pageSize, Model model) {
        InfoResponseDto responseDto = informationService.read(info_id);
        model.addAttribute("info", responseDto);
        model.addAttribute(page);
        model.addAttribute(pageSize);
        return "/information/info";
    }

    @MemberSignInCheck
    @GetMapping("/write")
    public String write() {
        return "/information/infoWrite";
    }

    @PostMapping("/write/{member_id}")
    public String writeSave(@PathVariable Long member_id, InfoSaveRequestDto requestDto) {
        MemberUpdateResponseDto memberUpdateResponseDto = memberService.findInfoById(member_id);
        requestDto.setWriter(memberUpdateResponseDto.getName());
        requestDto.setMember_id(member_id);
        informationService.write(requestDto);
        return "redirect:/info/list";
    }

    @GetMapping("/delete/{member_id}/{info_id}")
    public String infoDelete(@PathVariable Long member_id, @PathVariable Long info_id, HttpSession session, RedirectAttributes attributes) {
        memberService.verify(member_id, session);
        Long remove = informationService.remove(info_id, member_id);
        if (remove == 1) {
            attributes.addFlashAttribute("msg", "DEL_OK");
        }
        return "redirect:/info/list";
    }

    @MemberSignInCheck
    @GetMapping("/modify/{member_id}/{info_id}")
    public String modify(@PathVariable Long member_id, @PathVariable Long info_id, HttpSession session, InfoUpdateRequestDto requestDto) {
        memberService.verify(member_id, session);
        return "/info/infoModify";
    }
}
