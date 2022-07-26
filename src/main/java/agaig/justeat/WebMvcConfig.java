package agaig.justeat;

import agaig.justeat.member.interceptor.MemberSignInCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MemberSignInCheckInterceptor())
                .addPathPatterns("/boards")
                .addPathPatterns("/members/info");
    }

}
