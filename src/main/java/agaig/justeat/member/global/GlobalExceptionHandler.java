package agaig.justeat.member.global;

import agaig.justeat.member.exception.SignInException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SignInException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String catcher(HttpServletResponse response, Exception e) throws IOException {
        System.out.println("접근 권한이 필요합니다.");
        response.sendRedirect("/members?error=1");
        return "/member/signIn";
    }
}
