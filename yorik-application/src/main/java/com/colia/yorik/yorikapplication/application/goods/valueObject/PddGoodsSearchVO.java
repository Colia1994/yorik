package com.colia.yorik.yorikapplication.application.goods.valueObject;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import com.pdd.pop.ext.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/27
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class PddGoodsSearchVO implements ValueObject<PddGoodsSearchVO> {


    /**
     * 商品列表
     */
    @JsonProperty("goods_list")
    private List<PddGoodsDetailVO> goodsList;

    /**
     * 翻页时必填前页返回的list_id值
     */
    @JsonProperty("list_id")
    private String listId;

    /**
     * 搜索id，建议生成推广链接时候填写，提高收益
     */
    @JsonProperty("search_id")
    private String searchId;

    /**
     * 搜索id，建议生成推广链接时候填写，提高收益
     */
    @JsonProperty("total_count")
    private Integer totalCount;

    @Override
    public boolean sameValueAs(PddGoodsSearchVO other) {
        return false;
    }
}
