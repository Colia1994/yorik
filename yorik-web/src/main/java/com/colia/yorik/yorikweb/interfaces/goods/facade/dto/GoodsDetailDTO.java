package com.colia.yorik.yorikweb.interfaces.goods.facade.dto;

import com.colia.yorik.yorikcommon.interfaces.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("商品详情")
public class GoodsDetailDTO extends BaseDTO {


    @ApiModelProperty("类目id")
    private String categoryId;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("商品类目id")
    private String catId;

    @ApiModelProperty("商品一~四级类目ID列表")
    private List<Long> catIds;

    @ApiModelProperty("优惠券面额,单位为分")
    private Long couponDiscount;

    @ApiModelProperty("优惠券失效时间,UNIX时间戳")
    private Long couponEndTime;


    @ApiModelProperty("优惠券门槛价格,单位为分")
    private Long couponMinOrderAmount;

    @ApiModelProperty("优惠券金额")
    private Long couponPrice;

    @ApiModelProperty("优惠券剩余数量")
    private Long couponRemainQuantity;

    @ApiModelProperty("优惠券生效时间,UNIX时间戳")
    private Long couponStartTime;

    @ApiModelProperty("优惠券总数量")
    private Long couponTotalQuantity;

    @ApiModelProperty("商品描述")
    private String goodsDesc;

    @ApiModelProperty("商品详情图列表")
    private List<String> goodsGalleryUrls;

    @ApiModelProperty("商品id")
    private Long goodsId;

    @ApiModelProperty("商品主图")
    private String goodsImageUrl;

    @ApiModelProperty("商品实际价格")
    private Long goodsFactPrice;

    @ApiModelProperty("商品标准价格")
    private Long goodsMarkPrice;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品等级")
    private Long goodsRate;

    @ApiModelProperty("商品缩略图")
    private String goodsThumbnailUrl;

    @ApiModelProperty("商品类型")
    private Integer goodsType;

    @ApiModelProperty("商品是否带券,true-带券,false-不带券")
    private Boolean hasCoupon;

    @ApiModelProperty("商家id")
    private Long mallId;

    @ApiModelProperty("店铺名称")
    private String mallName;

    @ApiModelProperty("市场服务费")
    private Long marketFee;

    @ApiModelProperty("商家类型")
    private String merchantType;

    @ApiModelProperty("最小成团价格，单位分")
    private Long minGroupPrice;

    @ApiModelProperty("最小单买价格，单位分")
    private Long minNormalPrice;

    @ApiModelProperty("商品标签类目ID,使用pdd.goods.opt.get获取")
    private String optId;

    @ApiModelProperty("商品一~四级标签类目ID列表")
    private List<Long> optIds;

    @ApiModelProperty("商品标签名")
    private String optName;

    @ApiModelProperty("二维码主图")
    private String qrCodeImageUrl;

    @ApiModelProperty("销售量")
    private String salesTip;

    @ApiModelProperty("搜索id，建议生成推广链接时候填写，提高收益。")
    private String searchId;


    @ApiModelProperty("分享描述")
    private String shareDesc;
}
