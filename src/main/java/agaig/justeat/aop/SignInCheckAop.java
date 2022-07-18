package agaig.justeat.aop;

import agaig.justeat.service.MemberService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class SignInCheckAop {

    private final MemberService memberService;

    @Autowired
    public SignInCheckAop(MemberService memberService) {
        this.memberService = memberService;
    }

//    @Before("execution(* agaig.justeat.controller.MainController.*(..))")
    @Before("@annotation(agaig.justeat.annotation.MemberSignInCheck)")
    public void execute() throws Throwable {
        HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
        memberService.signInCheck(session);
    }
}
