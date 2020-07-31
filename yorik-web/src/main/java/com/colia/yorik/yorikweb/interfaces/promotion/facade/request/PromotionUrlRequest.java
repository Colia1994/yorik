package com.colia.yorik.yorikweb.interfaces.promotion.facade.request;

import com.colia.yorik.yorikcommon.interfaces.requestBody.RequestCommand;
import com.pdd.pop.ext.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/31
 */
@Data
@ApiModel("生成推广链接请求参数")
public class PromotionUrlRequest implements RequestCommand {


    /**
     * 自定义参数，为链接打上自定义标签；自定义参数最长限制64个字节；格式为： {"uid":"11111","sid":"22222"} ，
     * 其中 uid 用户唯一标识，可自行加密后传入，每个用户仅且对应一个标识，必填； sid 上下文信息标识，例如sessionId等，非必填。
     * 该json字符串中也可以加入其他自定义的key
     */
    @ApiModelProperty("自定义参数")
    private String customParameters;

    @ApiModelProperty(value = "是否生成店铺收藏券推广链接", example = "true")
    private Boolean generateMallCollectCoupon;

    @ApiModelProperty(value = "是否生成qq小程序", example = "false")
    private Boolean generateQqApp;

    @ApiModelProperty(value = "是否返回 schema URL", example = "true")
    private Boolean generateSchemaUrl;

    @ApiModelProperty(value = "是否生成短链接，true-是，false-否", example = "true")
    private Boolean generateShortUrl;

    @ApiModelProperty("是否生成唤起微信客户端链接，true-是，false-否，默认false")
    private Boolean generateWeappWebview;

    @ApiModelProperty(value = "是否生成微博推广链接", example = "false")
    private Boolean generateWeiboappWebview;

    @ApiModelProperty(value = "是否生成小程序推广", example = "true")
    private Boolean generateWeApp;

    @ApiModelProperty(value = "商品ID，仅支持单个查询", example = "true")
    private Long goodsId;

    @ApiModelProperty(value = "true--生成多人团推广链接 false--生成单人团推广链接（默认false）1、单人团推广链接：" +
            "用户访问单人团推广链接，可直接购买商品无需拼团。2、多人团推广链接：用户访问双人团推广链接开团，若用户分享给他人参团，" +
            "则开团者和参团者的佣金均结算给推手", example = "false")
    private Boolean multiGroup;

    @ApiModelProperty("搜索id 通过推荐和搜索接口获取 增加收益")
    private String searchId;


    /**
     * 指令验证
     */
    @Override
    public void validate() {

    }
}
