package com.colia.yorik.yorikapplication.application.goods.valueObject;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import lombok.Data;

import java.util.List;

/**
 * 淘宝客 默认推荐商品
 * https://open.taobao.com/api.htm?cid=1&docId=33947&docType=2
 *
 * @Author konglingyao
 * @Date 2020/8/4
 */
@Data
public class TBGoodsRecommendVO implements ValueObject<TBGoodsRecommendVO> {


    /**
     * 商品数据
     */
    private List<TBGoodsDetailVO> resultList;


    /**
     * 商品总数-目前只有全品库商品查询有该字段
     */
    private Long totalCount;

    /**
     * 推荐信息-是否抄底
     */
    private Boolean isDefault;


    @Override
    public boolean sameValueAs(TBGoodsRecommendVO other) {
        return false;
    }
}
