package com.colia.yorik.yorikweb.interfaces.goods.facade;

import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.request.GoodsRecommendRequest;

/**
 * @Author konglingyao
 * @Date 2020/7/24
 */
public interface GoodsRecommendFacade {

    /**
     * 按需要推荐商品
     *
     * @param request 推荐参数
     * @return 推荐商品列表
     */
    GoodsListDTO recommendGoods(GoodsRecommendRequest request);
}
