package com.colia.yorik.yorikweb.interfaces.basic;

import com.colia.yorik.yorikapplication.application.promotion.PddPromotionService;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResultUtils;
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
    private PddPromotionService pddPromotionService;

    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public <T> AjaxResponse<T> healthCheck() {
        return AjaxResultUtils.renderSuccess("cl you", null);

    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public <T> AjaxResponse<T> test() {
        pddPromotionService.generatePromotionUrl(null);
        return AjaxResultUtils.renderSuccess("cl you", null);

    }


}
