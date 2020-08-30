package com.colia.yorik.web.infrastructure.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;


/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@Configuration //配置类
public class Swagger2Config {


    @Bean
    //前台api接口文档
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(webApiInfo())
                .select()//创建ApiSelectorBuilder对象
                .paths(((Predicate<String>) PathSelectors.regex("/admin/.*")::apply).negate()::test)//过滤掉 admin 接口
                .paths(((Predicate<String>) PathSelectors.regex("/error.*")::apply).negate()::test)//过滤掉 error 接口
                .paths(((Predicate<String>) PathSelectors.regex("/api/health/.*")::apply).negate()::test)//过滤掉 health 接口

                .build();
    }


    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("Yorik前台网站API")
                .description("此文档描述了Yorik前台网站的基本API接口")
                .version("1.0")
                .contact(new Contact("colia", "https://github.com/Colia1994", "colia@foxmail.com"))
                .build();
    }


}
