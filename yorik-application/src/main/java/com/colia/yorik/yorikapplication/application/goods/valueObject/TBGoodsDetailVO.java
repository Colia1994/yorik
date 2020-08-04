package com.colia.yorik.yorikapplication.application.goods.valueObject;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import lombok.Data;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/8/4
 */
@Data
public class TBGoodsDetailVO implements ValueObject<TBGoodsDetailVO> {


    /**
     * 聚划算价格，单位分
     */
    private String actPrice;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     *
     */
    private Long itemId;

    /**
     * 商品卖点
     */
    private List<String> itemUspList;

    /**
     *	聚划算id
     */
    private Long juId;

    /**
     * 开团结束时间
     */
    private Long onlineEndTime;

    /**
     * 开团时间
     */
    private Long onlineStartTime;

    /**
     * 原价
     */
    private String origPrice;

    /**
     * 	是否包邮
     */
    private Boolean payPostage;

    /**
     * pc链接
     */
    private String pcUrl;

    /**
     * pc主图
     */
    private String picUrlForPC;

    /**
     * 无线主图
     */
    private String picUrlForWL;

    /**
     * 频道id
     */
    private Long platformId;

    /**
     * 聚划算价格，单位分
     */
    private List<String> priceUspList;

    /**
     * 	展示结束时间
     */
    private Long showEndTime;

    /**
     * 开始展示时间
     */
    private Long showStartTime;

    /**
     * 淘宝类目id
     */
    private Long tbFirstCatId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 卖点描述
     */
    private List<String> uspDescList;

    /**
     * 无线链接
     */
    private String wapUrl;

    @Override
    public boolean sameValueAs(TBGoodsDetailVO other) {
        return false;
    }
}
