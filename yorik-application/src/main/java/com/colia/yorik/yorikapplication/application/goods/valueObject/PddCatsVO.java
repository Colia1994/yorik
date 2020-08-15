package com.colia.yorik.yorikapplication.application.goods.valueObject;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import com.pdd.pop.ext.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * pdd 商品类目
 *
 * @Author konglingyao
 * @Date 2020/8/10
 */
@Data
public class PddCatsVO implements ValueObject<PddCatsVO> {


    /**
     * 类目树对象
     */
    @JsonProperty("goods_cats_list")
    private List<PddCatVO> goodsCatsList;


    @Override
    public boolean sameValueAs(PddCatsVO other) {
        return false;
    }

    @Data
    public static class PddCatVO implements ValueObject<PddCatVO> {
        /**
         * 类目层级，1-一级类目，2-二级类目，3-三级类目，4-四级类目
         */
        private Integer level;

        /**
         * 商品类目名称
         */
        private String catName;

        /**
         * id所属父类目ID，其中，parent_id=0时为顶级节点
         */
        private Long parentCatId;

        /**
         * 商品类目ID
         */
        private Long catId;

        @Override
        public boolean sameValueAs(PddCatVO other) {
            return false;
        }
    }
}
