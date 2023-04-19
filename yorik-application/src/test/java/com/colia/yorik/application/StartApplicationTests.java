package com.colia.yorik.application;

import com.colia.yorik.application.promotion.PddPromotionService;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class StartApplicationTests {

    @Resource
    private PddPromotionService pddPromotionService;

    @Test
    void contextLoads() {
        pddPromotionService.createOnePromotion("colia_main_1");
    }


    @Test
    void testRunner(){
        DefaultContext<String,Object> context = new DefaultContext<>();

        context.put("d","{\"0\":\"A,B\",\"1\":\"D,C\"}");
        ExpressRunner runner = new ExpressRunner();
        String jsonRule = "{\"0\":\"C\",\"1\":\"D\"}";

        String express = String.format("JSONAntMatch(d,'%s')", jsonRule);
        System.out.println(express);

        try {
            Object result = runner.execute(express,context,null,false,false);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
