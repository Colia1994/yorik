package com.colia.yorik.yorikweb.interfaces.goods.facade.impl;

import com.colia.yorik.yorikapplication.application.goods.PddGoodsService;
import com.colia.yorik.yorikweb.interfaces.goods.facade.GoodsRecommendFacade;
import com.colia.yorik.yorikweb.interfaces.goods.facade.adapter.GoodsDetailDTOAssembler;
import com.colia.yorik.yorikweb.interfaces.goods.facade.adapter.GoodsListDTOAssembler;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.request.GoodsDetailRequest;
import com.colia.yorik.yorikweb.interfaces.goods.facade.request.GoodsRecommendRequest;
import com.colia.yorik.yorikweb.interfaces.goods.facade.request.GoodsSearchRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsDetailRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsRecommendGetRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsSearchRequest;
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
        return listAssembler.toDTO(pddGoodsService.getPddRecommendGoods(pddRequest));
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
        return detailAssembler.toDTO(pddGoodsService.getPddGoodsDetailInfo(pddRequest).get(0));
    }

    /**
     * 搜索商品
     *
     * @param params 参数
     * @return 商品列表
     */
    @Override
    public GoodsListDTO searchGoods(GoodsSearchRequest params) {
        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
        request.setActivityTags(params.getActivityTags());
        request.setKeyword(params.getKeyword());
        request.setWithCoupon(params.getWithCoupon());
        request.setPage(params.getPageNo());
        request.setPageSize(params.getPageSize());
        request.setListId(params.getListId());
        request.setSortType(params.getSortType());
        return listAssembler.toDTO(pddGoodsService.searchPddGoods(request));
    }
}
