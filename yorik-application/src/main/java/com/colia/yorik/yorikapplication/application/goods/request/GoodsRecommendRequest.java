package com.colia.yorik.yorikapplication.application.goods.request;

import com.colia.yorik.yorikcommon.interfaces.requestBody.PageCommand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 *
 * @Author konglingyao
 * @Date 2020/7/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "推荐商品请求参数")
public class GoodsRecommendRequest extends PageCommand {


    @ApiModelProperty(name = "渠道", example = "1", value = "0-1.9包邮, 1-今日爆款, 2-品牌清仓,3-相似商品推荐,4-猜你喜欢,5-实时热销,6-实时收益,7-今日畅销,8-高佣榜单，默认1")
    private Integer channelType;

    @ApiModelProperty(name = "猜你喜欢类目", example = "20100", value = "猜你喜欢场景的商品类目，20100-百货，20200-母婴，20300-食品，20400-女装，20500-电器，20600-鞋包，20700-内衣，20800-美妆，20900-男装，21000-水果，21100-家纺，21200-文具,21300-运动,21400-虚拟,21500-汽车,21600-家装,21700-家具,21800-医药;")
    private Long catId;


    @Override
    public void validate() {

    }
}
