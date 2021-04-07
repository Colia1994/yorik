package com.colia.yorik.web.interfaces.promotion.controller;

import com.colia.yorik.application.common.CommonService;
import com.colia.yorik.application.promotion.PddPromotionService;
import com.colia.yorik.application.promotion.request.ConvertUrlRequest;
import com.colia.yorik.application.promotion.request.PromotionUrlRequest;
import com.colia.yorik.support.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.support.interfaces.ajaxresult.AjaxResultUtils;
import com.colia.yorik.web.interfaces.promotion.facade.PromotionFacade;
import com.colia.yorik.web.interfaces.promotion.facade.dto.UrlDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PromotionController {

    @Resource
    private PromotionFacade promotionFacade;
    @Resource
    private  PddPromotionService pddPromotionService;

    @Resource
    private CommonService commonService;


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
        log.info("任务开始输送");

        commonService.saveDailyBmpParam("1");
        commonService.saveDailyBmpParam("2");
        commonService.saveDailyBmpParam("3");
        commonService.saveDailyBmpParam("4");
        commonService.saveDailyBmpParam("5");
        commonService.saveDailyBmpParam("6");
        commonService.saveDailyBmpParam("7");
        commonService.saveDailyBmpParam("8");
        commonService.saveDailyBmpParam("9");
        commonService.saveDailyBmpParam("10");
        commonService.saveDailyBmpParam("14");

        log.info("任务输送完毕");
        return AjaxResultUtils.renderSuccess();
    }
}
