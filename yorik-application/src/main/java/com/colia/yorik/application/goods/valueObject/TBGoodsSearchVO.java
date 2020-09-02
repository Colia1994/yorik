package com.colia.yorik.application.goods.valueObject;

import com.colia.yorik.common.domain.vo.ValueObject;
import lombok.Data;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/9/2
 */
@Data
public class TBGoodsSearchVO implements ValueObject<TBGoodsSearchVO> {

    /**
     * 明细
     */
    private List<TBGoodsSearchVO> resultList;

    /**
     * 搜索到符合条件的结果总数
     */
    private Long totalResults;



    @Override
    public boolean sameValueAs(TBGoodsSearchVO other) {
        return false;
    }
}
