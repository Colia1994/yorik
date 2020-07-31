package com.colia.yorik.yorikweb.interfaces.promotion.controller;

import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResultUtils;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.request.GoodsRecommendRequest;
import com.colia.yorik.yorikweb.interfaces.promotion.facade.PromotionFacade;
import io.swagger.annotations.ApiOperation;
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
public class PromotionController {

    @Resource
    private PromotionFacade promotionFacade;


    @ResponseBody
    @RequestMapping(value = "/pdd/getRecommendGoods", method = RequestMethod.POST)
    @ApiOperation(value = "获取推荐商品信息")
    public AjaxResponse<GoodsListDTO> getGoodsList(@RequestBody GoodsRecommendRequest params) {
        return AjaxResultUtils.renderSuccess("cl you", null);

    }
}
