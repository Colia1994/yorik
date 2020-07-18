package com.colia.yorik.yorikweb.interfaces.controller;

import com.colia.yorik.yorikapplication.application.goods.RecommendGoodsService;
import com.colia.yorik.yorikapplication.application.goods.dto.GoodsBasicDetailDTO;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@RestController
@RequestMapping("/goods")
@Api(tags = "goods-controller",description = "商品管理")
public class GoodsController {

    @Resource
    private RecommendGoodsService recommendGoodsService;


    @RequestMapping(value = "/getGoodsList", method = RequestMethod.POST)
    @ApiOperation("获取推荐商品信息")
    public AjaxResponse<GoodsBasicDetailDTO> getGoodsList() {
        return AjaxResultUtils.renderSuccess("fuck you",
                recommendGoodsService.getRecommendGoods("", ""));

    }
}
