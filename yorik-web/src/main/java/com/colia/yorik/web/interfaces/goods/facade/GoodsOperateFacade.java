package com.colia.yorik.web.interfaces.goods.facade;

import com.colia.yorik.application.goods.request.GoodsDetailRequest;
import com.colia.yorik.application.goods.request.GoodsRecommendRequest;
import com.colia.yorik.application.goods.request.GoodsSearchRequest;
import com.colia.yorik.web.interfaces.goods.facade.dto.GoodsCatsDTO;
import com.colia.yorik.web.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.web.interfaces.goods.facade.dto.GoodsListDTO;

/**
 * @Author konglingyao
 * @Date 2020/7/24
 */
public interface GoodsOperateFacade {

    /**
     * 按需要推荐商品
     *
     * @param request 推荐参数
     * @return 推荐商品列表
     */
    GoodsListDTO recommendGoods(GoodsRecommendRequest request);


    /**
     * 根据商品id查询商品详情
     *
     * @param request 商品id等信息
     * @return 商品详情
     */
    GoodsDetailDTO getGoodsDetailById(GoodsDetailRequest request);


    /**
     * 搜索商品
     *
     * @param params 参数
     * @return 商品列表
     */
    GoodsListDTO searchGoods(GoodsSearchRequest params);


    /**
     * 查询商品类目
     *
     * @param sourceType 1 pdd 2 淘宝 默认1
     * @return 商品类目信息
     */
    GoodsCatsDTO getAllCats(int sourceType);


}
