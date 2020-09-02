package com.colia.yorik.application.goods;

import com.colia.yorik.application.goods.request.GoodsSearchRequest;
import com.colia.yorik.application.goods.valueObject.TBGoodsRecommendVO;
import com.colia.yorik.application.goods.valueObject.TBGoodsSearchVO;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;

/**
 * 淘宝 商品查询
 * https://open.taobao.com/api.htm?docId=28762&docType=2&scopeId=16517
 *
 * @Author konglingyao
 * @Date 2020/8/4
 */
public interface TaoBaoGoodsService {


    /**
     * 淘宝 精品商品推荐 支持
     *
     * @param req 查询条件
     * @return 商品结果
     */
    TBGoodsRecommendVO getRecommend(TbkDgOptimusMaterialRequest req);

    /**
     * 淘宝客 搜索商品接口
     * https://open.taobao.com/api.htm?cid=1&docId=35896&docType=2
     *
     * @param req 统一请求参数
     * @return 搜索数据结果
     */
    TBGoodsSearchVO searchTBGoods(GoodsSearchRequest req);

}
