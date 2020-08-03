package com.colia.yorik.yorikweb.interfaces.promotion.controller;

import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResultUtils;
import com.colia.yorik.yorikweb.interfaces.promotion.facade.PromotionFacade;
import com.colia.yorik.yorikweb.interfaces.promotion.facade.dto.UrlDTO;
import com.colia.yorik.yorikweb.interfaces.promotion.facade.request.PromotionUrlRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 推广转链接相关
 *
 * @Author konglingyao
 * @Date 2020/7/29
 */
@Controller
@RequestMapping("/api/promotion")
@Api(tags = "promotion-controller", description = "链接生成管理")
public class PromotionController {

    @Resource
    private PromotionFacade promotionFacade;


    @ResponseBody
    @RequestMapping(value = "/generateUrl", method = RequestMethod.POST)
    @ApiOperation(value = "生成推广链接")
    public AjaxResponse<UrlDTO> generateUrl(@RequestBody PromotionUrlRequest params) {
        params.validate();
        return AjaxResultUtils.renderSuccess(promotionFacade.generatePromotionUrl(params));

    }
}
