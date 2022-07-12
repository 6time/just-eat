package agaig.justeat.jiwon.controller;

import agaig.justeat.jiwon.model.aws.dto.portfolio;
import agaig.justeat.jiwon.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final TestService testService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/test")
    public List<portfolio> test(){

        return testService.getAllDataList();
    }


}
