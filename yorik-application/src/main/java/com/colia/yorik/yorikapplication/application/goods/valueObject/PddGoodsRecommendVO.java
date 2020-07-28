package com.colia.yorik.yorikapplication.application.goods.valueObject;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/21
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class PddGoodsRecommendVO implements ValueObject<PddGoodsRecommendVO> {

    /**
     * 列表
     */
    private List<PddGoodsDetailVO> list;

    /**
     * 翻页时必填前页返回的list_id值
     */
    private String listId;

    /**
     * 搜索id，建议生成推广链接时候填写，提高收益
     */
    private String searchId;

    /**
     * 总数目
     */
    private Integer total;

    @Override
    public boolean sameValueAs(PddGoodsRecommendVO other) {
        return false;
    }

}
