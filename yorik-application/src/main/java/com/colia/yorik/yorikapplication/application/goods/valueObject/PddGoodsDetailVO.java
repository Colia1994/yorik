package com.colia.yorik.yorikapplication.application.goods.valueObject;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import lombok.Data;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/21
 */
@Data
public class PddGoodsDetailVO implements ValueObject<PddGoodsDetailVO> {


    /**
     * 类目id
     */
    private String categoryId;


    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 商品类目id
     */
    private String catId;

    /**
     * 商品一~四级类目ID列表
     */
    private List<Long> catIds;

    /**
     * 优惠券面额,单位为分
     */
    private Long couponDiscount;

    /**
     * 优惠券失效时间,UNIX时间戳
     */
    private Long couponEndTime;

    /**
     * 优惠券门槛价格,单位为分
     */
    private Long couponMinOrderAmount;

    /**
     * 优惠券金额
     */
    private Long couponPrice;

    /**
     * 优惠券剩余数量
     */
    private Long couponRemainQuantity;

    /**
     * 优惠券生效时间,UNIX时间戳
     */
    private Long couponStartTime;

    /**
     * 优惠券总数目
     */
    private Long couponTotalQuantity;

    /**
     * 创建时间
     */
    private Long createAt;

    /**
     * 描述分
     */
    private String descTxt;

    /**
     * 商品描述
     */
    private String goodsDesc;

    /**
     * 商品实际价格
     */
    private Long goodsFactPrice;

    /**
     * 商品详情图列表
     */
    private String goodsGalleryUrls;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品主图
     */
    private String goodsImageUrl;

    /**
     * 商品标准价格
     */
    private Long goodsMarkPrice;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品登记
     */
    private Long goodsRate;

    /**
     * 商品缩略图
     */
    private String goodsThumbnailUrl;

    /**
     * 商品类型
     */
    private Integer goodsType;

    /**
     * 商品是否带券,true-带券,false-不带券
     */
    private Boolean hasCoupon;

    /**
     * 物流分
     */
    private String lgstTxt;

    /**
     * 商家id
     */
    private Long mallId;

    /**
     * 店铺名称
     */
    private String mallName;

    /**
     * 市场服务费
     */
    private Long marketFee;

    /**
     * 商家类型
     */
    private String merchantType;

    /**
     * 最小成团价格，单位分
     */
    private Long minGroupPrice;

    /**
     * 最小单买价格，单位分
     */
    private Long minNormalPrice;

    /**
     * 商品标签类目ID,使用pdd.goods.opt.get获取
     */
    private String optId;

    /**
     * 商品一~四级标签类目ID列表
     */
    private List<Long> optIds;

    /**
     * 商品标签名
     */
    private String optName;

    /**
     * 佣金比例,千分比
     */
    private Long promotionRate;

    /**
     * 二维码主图
     */
    private String qrCodeImageUrl;

    /**
     * 销售量
     */
    private String salesTip;

    /**
     * 搜索id，建议生成推广链接时候填写，提高收益。
     */
    private String searchId;

    /**
     * 服务分
     */
    private String servTxt;

    /**
     * 分享描述
     */
    private String shareDesc;

    @Override
    public boolean sameValueAs(PddGoodsDetailVO other) {
        return false;
    }
}
