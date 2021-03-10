package com.colia.yorik.web.interfaces.Test;

import com.colia.yorik.common.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.support.utils.ApplicationContextUtils;
import com.colia.yorik.support.utils.JSONUtil;
import com.colia.yorik.web.interfaces.order.facade.dto.OrderListDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @Author konglingyao
 * @Date 2020/7/26
 */
@Controller
@RequestMapping("/api/test")
public class TestController {


    @GetMapping("/parse")
    public AjaxResponse<OrderListDTO> parse() {
        String path = "classpath:job-step-skip-test.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        TestResource process = (TestResource) context.getBean("student");
        System.out.println(JSONUtil.transferToJson(process));
        System.out.println(Arrays.toString(context.getParent().getBeanDefinitionNames()));



        TestResource process1 = (TestResource) ApplicationContextUtils.getBean("student");
        System.out.println(JSONUtil.transferToJson(process1));

        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        return null;

    }

    @GetMapping("/parse1")
    public AjaxResponse<OrderListDTO> parse1() {
        TestResource process = (TestResource) ApplicationContextUtils.getBean("student");

        System.out.println(JSONUtil.transferToJson(process));
//        parseBatchXMLService.executeJob(path);
//        JobViewDTO jobViewDTO = new JobViewDTO();
        return null;
    }


}
