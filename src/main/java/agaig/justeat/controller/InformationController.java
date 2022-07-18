package agaig.justeat.controller;

import agaig.justeat.dto.InfoBoardResponseDto;
import agaig.justeat.dto.InfoResponseDto;
import agaig.justeat.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/info")
public class InformationController {

    private final InformationService informationService;

    @Autowired
    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/list")
    public String list(Integer page, Integer pageSize, Model model) {
        if (page == null) page = 1;
        if (pageSize == null) pageSize = 10;
        Map<String, Integer> map = new HashMap<>();
        map.put("offset", (page - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<InfoBoardResponseDto> boardList = informationService.getPage(map);
        model.addAttribute("infoBoardList", boardList);
        return "information/infoList";
    }

    @GetMapping("/{info_id}")
    public String info(@PathVariable Long info_id, Model model) {
        InfoResponseDto responseDto = informationService.read(info_id);
        model.addAttribute("info", responseDto);
        return "/information/info";
    }
}
