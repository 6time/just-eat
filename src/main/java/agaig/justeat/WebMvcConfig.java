package agaig.justeat;

import agaig.justeat.member.interceptor.MemberSignInCheckInterceptor;
import agaig.justeat.member.interceptor.MemberVerifyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MemberSignInCheckInterceptor())
                .addPathPatterns("/members/info")
                .addPathPatterns("/info/write/*");
        registry.addInterceptor(new MemberVerifyInterceptor())
                .addPathPatterns("/info/modify/*")
                .addPathPatterns("/info/delete/*")
                .addPathPatterns("/info/*");
    }
}
