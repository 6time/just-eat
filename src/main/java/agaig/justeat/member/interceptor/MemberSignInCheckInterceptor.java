package agaig.justeat.member.interceptor;

import agaig.justeat.member.exception.ErrorCode;
import agaig.justeat.member.exception.SignInException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class MemberSignInCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws SignInException{
        Optional.ofNullable(request.getSession().getAttribute("session"))
                .orElseThrow(() ->
                        new SignInException("로그인이 필요합니다.", ErrorCode.ADMIN_NOT_FOUND));
        return false;
    }
}
