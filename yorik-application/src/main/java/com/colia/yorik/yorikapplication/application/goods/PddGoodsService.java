package com.colia.yorik.yorikapplication.application.goods;

import com.colia.yorik.yorikapplication.application.goods.dto.GoodsBasicDetailDTO;
import com.colia.yorik.yorikcommon.application.AppService;

/**
 * @Author konglingyao
 * @Date 2020/7/15
 */
public interface PddGoodsService extends AppService {

    /**
     * pdd推荐商品
     * @return 商品流list
     */
    GoodsBasicDetailDTO getRecommendGoods();


    void getGoodsBasicInfo();
}
