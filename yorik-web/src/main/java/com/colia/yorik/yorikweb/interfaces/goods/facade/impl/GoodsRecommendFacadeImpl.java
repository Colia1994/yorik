package com.colia.yorik.yorikweb.interfaces.goods.facade.impl;

import com.colia.yorik.yorikapplication.application.goods.PddGoodsService;
import com.colia.yorik.yorikweb.interfaces.goods.adapter.GoodsBasicDetailDTOAssembler;
import com.colia.yorik.yorikweb.interfaces.goods.facade.GoodsRecommendFacade;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.request.GoodsRecommendRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsRecommendGetRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author konglingyao
 * @Date 2020/7/24
 */
@Slf4j
@Service
public class GoodsRecommendFacadeImpl implements GoodsRecommendFacade {

    @Resource
    private GoodsBasicDetailDTOAssembler assembler;

    @Resource
    private PddGoodsService pddGoodsService;


    /**
     * 按需要推荐商品
     *
     * @param request 推荐参数
     * @return 推荐商品列表
     */
    @Override
    public GoodsListDTO recommendGoods(GoodsRecommendRequest request) {
        PddDdkGoodsRecommendGetRequest pddRequest = new PddDdkGoodsRecommendGetRequest();
        pddRequest.setChannelType(request.getChannelType());
        pddRequest.setLimit(request.getPageSize());
        //offset 需要计算
        pddRequest.setOffset((request.getPageNo() - 1) * request.getPageSize());
        pddRequest.setCatId(request.getCatId());
        return assembler.toDTO(pddGoodsService.getRecommendGoods(pddRequest));
    }
}
