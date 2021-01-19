package com.colia.yorik.web.interfaces.promotion.controller;

import com.colia.yorik.application.promotion.PddPromotionService;
import com.colia.yorik.application.promotion.request.ConvertUrlRequest;
import com.colia.yorik.application.promotion.request.PromotionUrlRequest;
import com.colia.yorik.common.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.common.interfaces.ajaxresult.AjaxResultUtils;
import com.colia.yorik.web.interfaces.promotion.facade.PromotionFacade;
import com.colia.yorik.web.interfaces.promotion.facade.dto.UrlDTO;
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
    @Resource
    private  PddPromotionService pddPromotionService;


    @ResponseBody
    @RequestMapping(value = "/generateUrl", method = RequestMethod.POST)
    @ApiOperation(value = "生成推广链接")
    public AjaxResponse<UrlDTO> generateUrl(@RequestBody PromotionUrlRequest params) {
        params.validate();
        return AjaxResultUtils.renderSuccess(promotionFacade.generatePromotionUrl(params));
    }

    @ResponseBody
    @RequestMapping(value = "/convertUrl", method = RequestMethod.POST)
    @ApiOperation(value = "转换链接")
    public AjaxResponse<UrlDTO> convertUrl(@RequestBody ConvertUrlRequest params) {
        params.validate();
        return AjaxResultUtils.renderSuccess(promotionFacade.convertPromotionUrl(params));
    }

    @ResponseBody
    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    @ApiOperation(value = "测试用")
    public AjaxResponse<Object> convertUrl1() {
        pddPromotionService.pddDdkMemberAuthorityQuery();
        return AjaxResultUtils.renderSuccess();
    }

    @ResponseBody
    @RequestMapping(value = "/test02", method = RequestMethod.GET)
    @ApiOperation(value = "测试用")
    public AjaxResponse<Object> convertUrl2() {
        pddPromotionService.pddDdkRpPromUrlGenerate();
        return AjaxResultUtils.renderSuccess();
    }
}
