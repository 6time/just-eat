package agaig.justeat.member.interceptor;

import agaig.justeat.member.exception.ErrorCode;
import agaig.justeat.member.exception.SignInException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MemberVerifyInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws SignInException {
        System.out.println("Long.parseLong(request.getParameter(\"member_id\")) = " + Long.parseLong(request.getParameter("member_id")));
        if (!(Long.parseLong(request.getParameter("member_id")) == ((Long) request.getSession().getAttribute("session")))) {
            throw new SignInException("잘못된 접근입니다.", ErrorCode.ADMIN_NOT_FOUND);
        }
        return true;
    }
}
