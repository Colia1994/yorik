package com.colia.yorik.yorikweb.interfaces.goods.controller;

import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResultUtils;
import com.colia.yorik.yorikweb.interfaces.goods.facade.GoodsRecommendFacade;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.request.GoodsDetailRequest;
import com.colia.yorik.yorikweb.interfaces.goods.facade.request.GoodsRecommendRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@RestController
@RequestMapping("/api/goods")
@Api(tags = "goods-controller", description = "商品管理")
public class GoodsController {

    @Resource
    private GoodsRecommendFacade goodsRecommendFacade;


    @ResponseBody
    @RequestMapping(value = "/pdd/getRecommendGoods", method = RequestMethod.POST)
    @ApiOperation(value = "获取推荐商品信息")
    public AjaxResponse<GoodsListDTO> getGoodsList(@RequestBody GoodsRecommendRequest params) {
        return AjaxResultUtils.renderSuccess("cl you",
                goodsRecommendFacade.recommendGoods(params));

    }

    @ResponseBody
    @RequestMapping(value = "/pdd/getGoodsDetail", method = RequestMethod.POST)
    @ApiOperation(value = "获取商品详情")
    public AjaxResponse<GoodsDetailDTO> getGoodsList(@RequestBody GoodsDetailRequest params) {
        return AjaxResultUtils.renderSuccess("cl you",
                goodsRecommendFacade.getGoodsDetailById(params));

    }


}
