package com.colia.yorik.application;

import com.colia.yorik.yorikapplication.application.promotion.PddPromotionService;
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

}
