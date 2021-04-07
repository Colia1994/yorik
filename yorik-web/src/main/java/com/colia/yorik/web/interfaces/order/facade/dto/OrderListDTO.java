package com.colia.yorik.web.interfaces.order.facade.dto;

import com.colia.yorik.support.interfaces.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 订单列表
 *
 * @Author konglingyao
 * @Date 2020/7/26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("订单列表")
public class OrderListDTO extends BaseDTO {

    @ApiModelProperty("查询最后一个订单id，用于下一页")
    private String lastOrderId;

    @ApiModelProperty("数目")
    private Integer totalCount;

    @ApiModelProperty("订单集合")
    private List<OrderDetailDTO> orderList;
}
