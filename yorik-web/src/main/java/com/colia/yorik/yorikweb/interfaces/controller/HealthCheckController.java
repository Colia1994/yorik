package com.colia.yorik.yorikweb.interfaces.controller;

import com.colia.yorik.yorikapplication.application.goods.dto.GoodsBasicDetailDTO;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResultUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author konglingyao
 * @Date 2020/7/20
 */
@Controller
@RequestMapping("/health")
public class HealthCheckController {


    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ApiOperation(value = "健康检查", notes = "健康检查")
    public AjaxResponse<GoodsBasicDetailDTO> getGoodsList() {
        return AjaxResultUtils.renderSuccess("cl you", null
        );

    }
}
