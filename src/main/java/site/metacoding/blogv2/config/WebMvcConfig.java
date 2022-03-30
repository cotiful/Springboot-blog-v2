package site.metacoding.blogv2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import site.metacoding.blogv2.config.intercepter.SessionIntercepter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionIntercepter())
                .addPathPatterns("/s/**"); // *, ** 별 한개일 때, 별 2개일 때도 있어서 둘 다 테스트 해보세요!
    }

    // 패턴 추가 등록 더 할 수 있음!!
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    // registry.addInterceptor(new SessionIntercepter())
    // .addPathPatterns("/s/*")
    // .addPathPatterns("/user/*")
    // .excludePathPatterns("/s/post/*");
    // }
}
