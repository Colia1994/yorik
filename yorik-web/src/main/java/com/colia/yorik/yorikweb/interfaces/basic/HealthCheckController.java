package com.colia.yorik.yorikweb.interfaces.basic;

import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResultUtils;
import com.colia.yorik.yoriksupport.utils.JasyptUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author konglingyao
 * @Date 2020/7/20
 */
@Controller
@RequestMapping("/api/health")
public class HealthCheckController {

    @Resource
    private JasyptUtils jasyptUtils;


    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public <T> AjaxResponse<T> healthCheck() {
        return AjaxResultUtils.renderSuccess("cl you", null);

    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public <T> AjaxResponse<T> test() {


        // 首先获取配置文件里的原始明文信息
//        String pwd = jasyptUtils.encrypt("");
//        String re = jasyptUtils.decrypt("");

        // 打印加密前后的结果对比
//        System.out.println("加密结果：" + pwd);
//        System.out.println("原始结果：" + re);

        return AjaxResultUtils.renderSuccess("cl you", null);

    }


}
