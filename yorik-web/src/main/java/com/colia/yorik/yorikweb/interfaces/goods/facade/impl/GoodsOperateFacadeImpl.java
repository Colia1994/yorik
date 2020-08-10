package com.colia.yorik.yorikweb.interfaces.goods.facade.impl;

import com.colia.yorik.yorikapplication.application.goods.PddGoodsService;
import com.colia.yorik.yorikweb.interfaces.goods.facade.GoodsOperateFacade;
import com.colia.yorik.yorikweb.interfaces.goods.facade.adapter.GoodsCatsDTOAssembler;
import com.colia.yorik.yorikweb.interfaces.goods.facade.adapter.GoodsDetailDTOAssembler;
import com.colia.yorik.yorikweb.interfaces.goods.facade.adapter.GoodsListDTOAssembler;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsCatDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsCatsDTO;
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
public class GoodsOperateFacadeImpl implements GoodsOperateFacade {

    @Resource
    private GoodsListDTOAssembler listAssembler;

    @Resource
    private GoodsDetailDTOAssembler detailAssembler;

    @Resource
    private PddGoodsService pddGoodsService;

    @Resource
    private GoodsCatsDTOAssembler catsDTOAssembler;


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

    /**
     * 查询商品类目
     *
     * @param sourceType 1 pdd 2 淘宝 默认1
     * @return 商品类目信息
     */
    @Override
    public GoodsCatsDTO getAllCats(int sourceType) {
        //pdd
        if (sourceType == 1) {
            List<GoodsCatDTO> goodsCatDTOs = new ArrayList<>();
            goodsCatDTOs.add(new GoodsCatDTO("女装", 8439L));
            goodsCatDTOs.add(new GoodsCatDTO("男装", 239L));
            goodsCatDTOs.add(new GoodsCatDTO("美食", 6398L));
            goodsCatDTOs.add(new GoodsCatDTO("美妆", 18482L));
            goodsCatDTOs.add(new GoodsCatDTO("日用", 16989L));
            goodsCatDTOs.add(new GoodsCatDTO("饰品", 17412L));
            goodsCatDTOs.add(new GoodsCatDTO("宠物", 16288L));
            GoodsCatsDTO goodsCatsDTO = new GoodsCatsDTO();
            goodsCatsDTO.setGoodsCatsList(goodsCatDTOs);
            return goodsCatsDTO;
        }
        return catsDTOAssembler.toDTO(pddGoodsService.searchPddCats());
    }
}
