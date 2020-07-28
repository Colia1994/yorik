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
     * 店铺收藏券id
     */
    private String cltCpnBatchSn;
    /**
     * 店铺收藏券面额,单位为分
     */
    private Long cltCpnDiscount;
    /**
     * 店铺收藏券截止时间
     */
    private Long cltCpnEndTime;
    /**
     * 店铺收藏券使用门槛价格,单位为分
     */
    private Long cltCpnMinAmt;
    /**
     * 店铺收藏券总量
     */
    private Long cltCpnQuantity;
    /**
     * 店铺收藏券剩余量
     */
    private Long cltCpnRemainQuantity;
    /**
     * 店铺收藏券起始时间
     */
    private Long cltCpnStartTime;


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
    private List<String> goodsGalleryUrls;

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
     * 是否有店铺券
     */
    private Boolean hasMallCoupon;

    /**
     * 物流分
     */
    private String lgstTxt;

    /**
     * 店铺折扣
     */
    private Integer mallCouponDiscountPct;
    /**
     * 店铺券使用结束时间
     */
    private Long mallCouponEndTime;
    /**
     * 最大使用金额
     */
    private Integer mallCouponMaxDiscountAmount;
    /**
     * 最小使用金额
     */
    private Integer mallCouponMinOrderAmount;
    /**
     * 店铺券余量
     */
    private Long mallCouponRemainQuantity;
    /**
     * 店铺券使用开始时间
     */
    private Long mallCouponStartTime;
    /**
     * 店铺券总量
     */
    private Long mallCouponTotalQuantity;


    /**
     * 该商品所在店铺是否参与全店推广，0：否，1：是
     */
    private Integer mallCps;

    /**
     * 商家id
     */
    private Long mallId;

    /**
     * 店铺名称
     */
    private String mallName;

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
     * 快手专享
     */
    private Boolean onlySceneAuth;

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
     * 推广计划类型
     */
    private Integer planType;

    /**
     * 佣金比例,千分比
     */
    private Long promotionRate;

    /**
     * 销售量
     */
    private String salesTip;

    /**
     * 服务标签: 4-送货入户并安装,5-送货入户,6-电子发票,9-坏果包赔,11-闪电退款,12-24小时发货,13-48小时发货,17-顺丰包邮,18-只换不修,1可定制化,29-预约配送,1000001-正品发票,1000002-送货入户并安装
     */
    private List<Integer> serviceTags;

    /**
     * 服务分
     */
    private String servTxt;

    /**
     * 招商团长id
     */
    private Long zsDuoId;

    /**
     * 商品视频url
     */
    private List<String> videoUrls;


    /**
     * 市场服务费
     */
    private Long marketFee;


    /**
     * 二维码主图
     */
    private String qrCodeImageUrl;


    /**
     * 搜索id，建议生成推广链接时候填写，提高收益。
     */
    private String searchId;


    /**
     * 分享描述
     */
    private String shareDesc;


    @Override
    public boolean sameValueAs(PddGoodsDetailVO other) {
        return false;
    }
}
