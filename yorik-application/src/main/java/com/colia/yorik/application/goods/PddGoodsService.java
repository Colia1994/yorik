package com.colia.yorik.application.goods;

import com.colia.yorik.application.goods.request.GoodsDetailRequest;
import com.colia.yorik.application.goods.request.GoodsRecommendRequest;
import com.colia.yorik.application.goods.request.GoodsSearchRequest;
import com.colia.yorik.application.goods.valueObject.*;
import com.colia.yorik.common.application.AppService;

import java.util.List;

/**
 * pdd 商品查询相关
 *
 * @Author konglingyao
 * @Date 2020/7/15
 */
public interface PddGoodsService extends AppService {

    /**
     * pdd推荐商品
     *
     * @param request pdd需要的请求参数
     * @return 商品流list
     */
    PddGoodsRecommendVO getPddRecommendGoods(GoodsRecommendRequest request);

//    /**
//     * pdd根据商品id获取基本信息
//     *
//     * @param goodsIdList 商品id列表
//     * @return 商品基本信息
//     */
//    List<PddGoodsBasicVO> getGoodsBasicInfoByID(List<Long> goodsIdList);

    /**
     * 获取pdd商品详情
     *
     * @param request 商品详情请求参数 goods_id
     * @return 商品详情
     */
    PddGoodsDetailVO getPddGoodsDetailInfo(GoodsDetailRequest request);

    /**
     * 搜索商品
     *
     * @param request 请求相关
     * @return 商品列表
     */
    PddGoodsSearchVO searchPddGoods(GoodsSearchRequest request);


    /**
     * pdd查询商品类目
     *
     * @return 类目信息
     */
    PddCatsVO searchPddCats();


}
