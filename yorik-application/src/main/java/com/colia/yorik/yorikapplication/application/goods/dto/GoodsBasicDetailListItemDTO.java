package com.colia.yorik.yorikapplication.application.goods.dto;

import com.colia.yorik.yorikcommon.interfaces.dto.BaseDTO;
import com.pdd.pop.ext.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBasicDetailListItemDTO extends BaseDTO {

    @JsonProperty("category_id")
    private String categoryId;
    @JsonProperty("category_name")
    private String categoryName;
    @JsonProperty("cat_id")
    private String catId;
    @JsonProperty("cat_ids")
    private List<Long> catIds;
    @JsonProperty("coupon_discount")
    private Long couponDiscount;
    @JsonProperty("coupon_end_time")
    private Long couponEndTime;
    @JsonProperty("coupon_min_order_amount")
    private Long couponMinOrderAmount;
    @JsonProperty("coupon_price")
    private Long couponPrice;
    @JsonProperty("coupon_remain_quantity")
    private Long couponRemainQuantity;
    @JsonProperty("coupon_start_time")
    private Long couponStartTime;
    @JsonProperty("coupon_total_quantity")
    private Long couponTotalQuantity;
    @JsonProperty("create_at")
    private Long createAt;
    @JsonProperty("desc_txt")
    private String descTxt;
    @JsonProperty("goods_desc")
    private String goodsDesc;
    @JsonProperty("goods_fact_price")
    private Long goodsFactPrice;
    @JsonProperty("goods_gallery_urls")
    private String goodsGalleryUrls;
    @JsonProperty("goods_id")
    private Long goodsId;
    @JsonProperty("goods_image_url")
    private String goodsImageUrl;
    @JsonProperty("goods_mark_price")
    private Long goodsMarkPrice;
    @JsonProperty("goods_name")
    private String goodsName;
    @JsonProperty("goods_rate")
    private Long goodsRate;
    @JsonProperty("goods_thumbnail_url")
    private String goodsThumbnailUrl;
    @JsonProperty("goods_type")
    private Integer goodsType;
    @JsonProperty("has_coupon")
    private Boolean hasCoupon;
    @JsonProperty("lgst_txt")
    private String lgstTxt;
    @JsonProperty("mall_id")
    private Long mallId;
    @JsonProperty("mall_name")
    private String mallName;
    @JsonProperty("market_fee")
    private Long marketFee;
    @JsonProperty("merchant_type")
    private String merchantType;
    @JsonProperty("min_group_price")
    private Long minGroupPrice;
    @JsonProperty("min_normal_price")
    private Long minNormalPrice;
    @JsonProperty("opt_id")
    private String optId;
    @JsonProperty("opt_ids")
    private List<Long> optIds;
    @JsonProperty("opt_name")
    private String optName;
    @JsonProperty("promotion_rate")
    private Long promotionRate;
    @JsonProperty("qr_code_image_url")
    private String qrCodeImageUrl;
    @JsonProperty("sales_tip")
    private String salesTip;
    @JsonProperty("search_id")
    private String searchId;
    @JsonProperty("serv_txt")
    private String servTxt;
    @JsonProperty("share_desc")
    private String shareDesc;
}
