package com.colia.yorik.web.infrastructure.config;

import com.colia.yorik.web.infrastructure.interceptor.CookieInterceptor;
import com.colia.yorik.web.infrastructure.interceptor.MyInterceptor;
import com.colia.yorik.web.infrastructure.interceptor.PermissionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author colia
 * @Date 2018-03-10
 */
@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {
    @Resource
    private PermissionInterceptor permissionInterceptor;

    @Resource
    private MyInterceptor myInterceptor;

    @Resource
    private CookieInterceptor cookieInterceptor;
    /**
     * 解决跨域问题
     *
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig());
        return new CorsFilter(source);
    }

    private CorsConfiguration corsConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //请求常用的三种配置，*代表允许所有，当时你也可以自定义属性（比如header只能带什么，只能是post方式等等）
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedOrigin("http://localhost:3333");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }



    /**
     * 拦截器
     *
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/SignUp","/login","/assets/**");
        registry.addInterceptor(permissionInterceptor).addPathPatterns("/**");
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
        registry.addInterceptor(cookieInterceptor).addPathPatterns("/**");
        //去除拦截静态资源
    }
}
