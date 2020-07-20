package com.colia.yorik.yorikweb.interfaces.goods.facade;

import com.colia.yorik.yorikcommon.interfaces.requestBody.PageCommand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author konglingyao
 * @Date 2020/7/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "推荐商品请求参数")
public class GoodsRecommendRequest extends PageCommand {

    @ApiParam(name = "开发者id（test阶段）")
    @ApiModelProperty("描述性原因")
    private String clientId;

    @ApiParam(name = "开发者密码（test阶段）")
    private String clientSecret;


    @ApiParam(name = "渠道", defaultValue = "1", example = "0-1.9包邮, 1-今日爆款, 2-品牌清仓,3-相似商品推荐,4-猜你喜欢,5-实时热销,6-实时收益,7-今日畅销,8-高佣榜单，默认1")
    private Integer channelType;

    @ApiParam(name = "猜你喜欢类目", defaultValue = "20100", example = "猜你喜欢场景的商品类目，20100-百货，20200-母婴，20300-食品，20400-女装，20500-电器，20600-鞋包，20700-内衣，20800-美妆，20900-男装，21000-水果，21100-家纺，21200-文具,21300-运动,21400-虚拟,21500-汽车,21600-家装,21700-家具,21800-医药;")
    private Long cat_id;



    @Override
    public void validate() {

    }
}
