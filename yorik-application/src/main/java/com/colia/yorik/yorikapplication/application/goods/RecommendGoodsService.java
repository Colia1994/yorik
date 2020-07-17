package com.colia.yorik.yorikapplication.application.goods;

import com.colia.yorik.yorikapplication.application.goods.dto.GoodsBasicDetailDTO;
import com.colia.yorik.yorikcommon.application.AppService;

/**
 * @Author konglingyao
 * @Date 2020/7/15
 */
public interface RecommendGoodsService extends AppService {

    GoodsBasicDetailDTO getRecommendGoods(String clientId, String clientSecret);

}
