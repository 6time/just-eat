//package agaig.justeat.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpSession;
//import java.util.Optional;
//
//@Aspect
//@Component
//public class SignInCheckAop {
//
//    @Around("execution(* agaig.justeat..*(..))")
//    public Object execute(ProceedingJoinPoint proceedingJoinPoint, HttpSession session) throws Throwable{
//        System.out.println("TEST");
//        try {
//            return proceedingJoinPoint.proceed();
//        } finally {
//            Optional.ofNullable(session.getAttribute("session"))
//                    .orElseThrow(() ->
//                            new IllegalStateException("로그인이 필요합니다."));
//        }
//
//    }
//
//}
