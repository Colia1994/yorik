package com.colia.yorik.yoriksupport.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author konglingyao
 * @Date 2020/7/22
 */
@Configuration
public class iConfiguration {

    @Bean
    public ServiceProxyFactoryBean<TestService> testCreatBean(){
        ServiceProxyFactoryBean<TestService> bean = new ServiceProxyFactoryBean<>();
        bean.setInterfaces(TestService.class);
        bean.setQueue("redis");
        bean.setObj(new TestServiceImpl());
        return bean;
    }
}
