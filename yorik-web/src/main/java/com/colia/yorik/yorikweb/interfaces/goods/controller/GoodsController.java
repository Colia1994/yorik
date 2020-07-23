package com.colia.yorik.yorikweb.interfaces.goods.controller;

import com.colia.yorik.yorikapplication.application.goods.RecommendGoodsService;
import com.colia.yorik.yorikapplication.application.goods.dto.GoodsBasicDetailDTO;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResultUtils;
import com.colia.yorik.yorikweb.interfaces.goods.facade.GoodsRecommendRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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


    @ResponseBody
    @RequestMapping(value = "/pdd/getRecommendGoods", method = RequestMethod.POST)
    @ApiOperation(value = "获取推荐商品信息")
    public AjaxResponse<GoodsBasicDetailDTO> getGoodsList(@RequestBody GoodsRecommendRequest params) {
        return AjaxResultUtils.renderSuccess("cl you",
                recommendGoodsService.getRecommendGoods(params.getClientId(), params.getClientSecret()));

    }




}
