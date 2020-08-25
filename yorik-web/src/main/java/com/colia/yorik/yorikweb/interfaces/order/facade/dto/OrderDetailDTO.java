package com.colia.yorik.yorikweb.interfaces.order.facade.dto;

import com.colia.yorik.common.interfaces.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 订单详情
 *
 * @Author konglingyao
 * @Date 2020/7/26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("订单详情")
public class OrderDetailDTO extends BaseDTO {

    /**
     * 是否是 cpa 新用户，1表示是，0表示否
     */
    private Integer cpaNew;

    /**
     * 自定义参数
     */
    private String customParameters;

    /**
     * 订单审核失败原因
     */
    private String failReason;

    @ApiModelProperty("商品id")
    private Long goodsId;

    /**
     * 商品标题
     */
    private String goodsName;

    /**
     * 订单中sku的单件价格，单位为分
     */
    private Long goodsPrice;

    /**
     * 购买商品的数量
     */
    private Long goodsQuantity;

    /**
     * 商品缩略图
     */
    private String goodsThumbnailUrl;

    /**
     * 实际支付金额，单位为分
     */
    private Long orderAmount;

    /**
     * 订单生成时间，UNIX时间戳
     */
    private Long orderCreateTime;

    /**
     * 成团时间
     */
    private Long orderGroupSuccessTime;

    /**
     * 最后更新时间
     */
    private Long orderModifyAt;

    /**
     * 支付时间
     */
    private Long orderPayTime;

    /**
     * 推广订单编号
     */
    private String orderSn;

    /**
     * 订单状态： -1 未支付; 0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）
     */
    private Integer orderStatus;

    /**
     * 订单状态描述
     */
    private String orderStatusDesc;

    /**
     * 审核时间
     */
    private Long orderVerifyTime;

    /**
     * 佣金金额，单位为分
     */
    private Long promotionAmount;

    /**
     * 佣金比例，千分比
     */
    private Long promotionRate;

    /**
     * 推广位ID
     */
    private String pId;

    /**
     * 订单类型：0：领券页面， 1： 红包页， 2：领券页， 3： 题页
     */
    private Integer type;

    /**
     * 商品一~四级类目ID列表
     */
    private List<Long> catIds;

    /**
     * 多多客工具id
     */
    private Long authDuoId;

    /**
     * 结算批次号
     */
    private String batchNo;

    /**
     * 成团编号
     */
    private Long groupId;

    /**
     * 确认收货时间
     */
    private Long orderReceiveTime;

    /**
     * 结算时间
     */
    private Long orderSettleTime;

    /**
     * 招商多多客id
     */
    private Long zsDuoId;

    /**
     * 是否直推 ，1表示是，0表示否
     */
    private Integer isDirect;
}
