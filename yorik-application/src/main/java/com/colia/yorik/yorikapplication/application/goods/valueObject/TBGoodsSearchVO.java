package com.colia.yorik.yorikapplication.application.goods.valueObject;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.response.JuItemsSearchResponse;
import lombok.Data;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/8/4
 */
@Data
public class TBGoodsSearchVO implements ValueObject<TBGoodsSearchVO> {

    /**
     * 页码
     */
    private Long currentPage;

//    /**
//     * 扩展属性
//     */
//    private JuItemsSearchResponse.Extend extend;

    /**
     * 商品数据
     */
    private List<JuItemsSearchResponse.Items> modelList;

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
    public boolean sameValueAs(TBGoodsSearchVO other) {
        return false;
    }
}
