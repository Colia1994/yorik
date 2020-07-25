package com.colia.yorik.yorikweb.interfaces.goods.facade.impl;

import com.colia.yorik.yorikapplication.application.goods.PddGoodsService;
import com.colia.yorik.yorikweb.interfaces.goods.adapter.GoodsDetailDTOAssembler;
import com.colia.yorik.yorikweb.interfaces.goods.adapter.GoodsListDTOAssembler;
import com.colia.yorik.yorikweb.interfaces.goods.facade.GoodsRecommendFacade;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.request.GoodsDetailRequest;
import com.colia.yorik.yorikweb.interfaces.goods.facade.request.GoodsRecommendRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsDetailRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsRecommendGetRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/24
 */
@Slf4j
@Service
public class GoodsRecommendFacadeImpl implements GoodsRecommendFacade {

    @Resource
    private GoodsListDTOAssembler listAssembler;

    @Resource
    private GoodsDetailDTOAssembler detailAssembler;


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
        return listAssembler.toDTO(pddGoodsService.getRecommendGoods(pddRequest));
    }

    /**
     * 根据商品id查询商品详情
     *
     * @param request 商品id等信息
     * @return 商品详情
     */
    @Override
    public GoodsDetailDTO getGoodsDetailById(GoodsDetailRequest request) {
        PddDdkGoodsDetailRequest pddRequest = new PddDdkGoodsDetailRequest();
        List<Long> goodsIdList = new ArrayList<>();
        goodsIdList.add(request.getGoodsId());
        pddRequest.setGoodsIdList(goodsIdList);
        pddRequest.setSearchId(request.getSearchId());
        pddRequest.setPid(request.getPid());
        pddRequest.setPlanType(request.getPlanType());
//        pddRequest.se(request.getPid());
        return detailAssembler.toDTO(pddGoodsService.getGoodsDetailInfo(pddRequest).get(0));
    }
}
