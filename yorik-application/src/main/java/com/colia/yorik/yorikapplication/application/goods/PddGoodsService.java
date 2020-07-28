package com.colia.yorik.yorikapplication.application.goods;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsBasicVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsDetailVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsRecommendVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsSearchVO;
import com.colia.yorik.yorikcommon.application.AppService;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsDetailRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsRecommendGetRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsSearchRequest;

import java.util.List;

/**
 * 商品查询相关
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
    PddGoodsRecommendVO getRecommendGoods(PddDdkGoodsRecommendGetRequest request);

    /**
     * pdd根据商品id获取基本信息
     *
     * @param goodsIdList 商品id列表
     * @return 商品基本信息
     */
    List<PddGoodsBasicVO> getGoodsBasicInfoByID(List<Long> goodsIdList);

    /**
     * 获取pdd商品详情
     *
     * @param request 商品详情请求参数 goods_id
     * @return 商品详情
     */
    List<PddGoodsDetailVO> getGoodsDetailInfo(PddDdkGoodsDetailRequest request);

    /**
     * 搜索商品
     *
     * @param request 请求相关
     * @return 商品列表
     */
    PddGoodsSearchVO searchGoods(PddDdkGoodsSearchRequest request);


}