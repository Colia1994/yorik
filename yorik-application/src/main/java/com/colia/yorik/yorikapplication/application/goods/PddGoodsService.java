package com.colia.yorik.yorikapplication.application.goods;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsListVO;
import com.colia.yorik.yorikcommon.application.AppService;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsRecommendGetRequest;

/**
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
    PddGoodsListVO getRecommendGoods(PddDdkGoodsRecommendGetRequest request);


    void getGoodsBasicInfo();
}
