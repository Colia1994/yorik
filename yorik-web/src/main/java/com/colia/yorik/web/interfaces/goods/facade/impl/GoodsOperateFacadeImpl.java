package com.colia.yorik.web.interfaces.goods.facade.impl;

import com.colia.yorik.application.goods.PddGoodsService;
import com.colia.yorik.application.goods.request.GoodsDetailRequest;
import com.colia.yorik.application.goods.request.GoodsRecommendRequest;
import com.colia.yorik.application.goods.request.GoodsSearchRequest;
import com.colia.yorik.web.interfaces.goods.facade.GoodsOperateFacade;
import com.colia.yorik.web.interfaces.goods.facade.adapter.GoodsCatsDTOAssembler;
import com.colia.yorik.web.interfaces.goods.facade.adapter.GoodsDetailDTOAssembler;
import com.colia.yorik.web.interfaces.goods.facade.adapter.GoodsListDTOAssembler;
import com.colia.yorik.web.interfaces.goods.facade.dto.GoodsCatDTO;
import com.colia.yorik.web.interfaces.goods.facade.dto.GoodsCatsDTO;
import com.colia.yorik.web.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.web.interfaces.goods.facade.dto.GoodsListDTO;
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

        return listAssembler.toDTO(pddGoodsService.getPddRecommendGoods(request));
    }

    /**
     * 根据商品id查询商品详情
     *
     * @param request 商品id等信息
     * @return 商品详情
     */
    @Override
    public GoodsDetailDTO getGoodsDetailById(GoodsDetailRequest request) {

        return detailAssembler.toDTO(pddGoodsService.getPddGoodsDetailInfo(request).get(0));
    }

    /**
     * 搜索商品
     *
     * @param params 参数
     * @return 商品列表
     */
    @Override
    public GoodsListDTO searchGoods(GoodsSearchRequest params) {

        return listAssembler.toDTO(pddGoodsService.searchPddGoods(params));
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
            goodsCatDTOs.add(new GoodsCatDTO("全部", null));
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
