package com.colia.yorik.yorikapplication.application.goods.valueObject;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import lombok.Data;

import java.util.List;

/**
 * 淘宝客 默认推荐商品
 *
 * @Author konglingyao
 * @Date 2020/8/4
 */
@Data
public class TBGoodsRecommendVO implements ValueObject<TBGoodsRecommendVO> {

    /**
     * 页码
     */
    private Long currentPage;

    /**
     * 商品数据
     */
    private List<TBGoodsDetailVO> modelList;

    /**
     * 错误码
     */
    private String msgCode;

    /**
     * 错误信息
     */
    private String msgInfo;

    /**
     * 一页大小
     */
    private Long pageSize;


    /**
     * 商品总数
     */
    private Long totalItem;

    /**
     * 总页数
     */
    private Long totalPage;


    @Override
    public boolean sameValueAs(TBGoodsRecommendVO other) {
        return false;
    }
}
