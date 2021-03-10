package com.colia.yorik.web.interfaces.basic;

import com.colia.yorik.common.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.common.interfaces.ajaxresult.AjaxResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author konglingyao
 * @Date 2020/7/20
 */
@Controller
@RequestMapping("/api/health")
public class HealthCheckController {


    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public <T> AjaxResponse<T> healthCheck() {
        return AjaxResultUtils.renderSuccess("cl you", null);

    }



}
