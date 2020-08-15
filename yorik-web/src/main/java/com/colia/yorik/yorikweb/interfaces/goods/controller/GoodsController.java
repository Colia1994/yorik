package com.colia.yorik.yorikweb.interfaces.goods.controller;

import com.colia.yorik.yorikapplication.application.goods.request.GoodsDetailRequest;
import com.colia.yorik.yorikapplication.application.goods.request.GoodsRecommendRequest;
import com.colia.yorik.yorikapplication.application.goods.request.GoodsSearchRequest;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResultUtils;
import com.colia.yorik.yorikweb.interfaces.goods.facade.GoodsOperateFacade;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsCatsDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品控制器
 *
 * @Author konglingyao
 * @Date 2020/7/17
 */
@RestController
@RequestMapping("/api/goods")
@Api(tags = "goods-controller", description = "商品管理")
public class GoodsController {

    @Resource
    private GoodsOperateFacade goodsRecommendFacade;


    @ResponseBody
    @RequestMapping(value = "/getRecommendGoods", method = RequestMethod.POST)
    @ApiOperation(value = "获取推荐商品信息")
    public AjaxResponse<GoodsListDTO> getGoodsList(@RequestBody GoodsRecommendRequest params) {
        return AjaxResultUtils.renderSuccess("cl you", goodsRecommendFacade.recommendGoods(params));

    }

    @ResponseBody
    @RequestMapping(value = "/getGoodsDetail", method = RequestMethod.POST)
    @ApiOperation(value = "获取商品详情")
    public AjaxResponse<GoodsDetailDTO> getGoodsDetail(@RequestBody GoodsDetailRequest params) {
        return AjaxResultUtils.renderSuccess("cl you", goodsRecommendFacade.getGoodsDetailById(params));
    }

    @ResponseBody
    @RequestMapping(value = "/searchGoods", method = RequestMethod.POST)
    @ApiOperation(value = "搜索商品")
    public AjaxResponse<GoodsListDTO> searchGoods(@RequestBody GoodsSearchRequest params) {

        return AjaxResultUtils.renderSuccess("cl you", goodsRecommendFacade.searchGoods(params));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllCats", method = RequestMethod.POST)
    @ApiOperation(value = "商品类目信息")
    public AjaxResponse<GoodsCatsDTO> getAllCats() {

        return AjaxResultUtils.renderSuccess("cl you", goodsRecommendFacade.getAllCats(1));
    }

}
