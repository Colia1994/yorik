package com.colia.yorik.yorikweb.interfaces.promotion.facade.dto;

import com.colia.yorik.common.interfaces.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author konglingyao
 * @Date 2020/7/29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "链接信息")
public class UrlDTO extends BaseDTO {

    @ApiModelProperty("唤醒拼多多app的推广短链接")
    private String pddShortUrl;

    @ApiModelProperty("唤醒拼多多app的推广长链接")
    private String pddUrl;

    @ApiModelProperty("schema的链接")
    private String schemaUrl;

    @ApiModelProperty("推广短链接")
    private String shortUrl;

    @ApiModelProperty("推广长链接")
    private String url;

    @ApiModelProperty("唤起微信app推广短链接")
    private String weAppWebViewShortUrl;

    @ApiModelProperty("唤起微信app推广链接")
    private String weAppWebViewUrl;

    @ApiModelProperty("微信小程序相关信息")
    private WeAppInfoDTO weAppInfo;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class WeAppInfoDTO extends BaseDTO {

        /**
         * 拼多多小程序id
         */
        @ApiModelProperty("拼多多小程序id")
        private String appId;

        /**
         * Banner图
         */
        @ApiModelProperty("Banner图")
        private String bannerUrl;

        /**
         * 描述
         */
        @ApiModelProperty("描述")
        private String desc;

        /**
         * 小程序path值
         */
        @ApiModelProperty("小程序path值")
        private String pagePath;

        /**
         * 来源名
         */
        @ApiModelProperty("来源名")
        private String sourceDisplayName;

        /**
         * 小程序标题
         */
        @ApiModelProperty("小程序标题")
        private String title;

        /**
         * 用户名
         */
        @ApiModelProperty("用户名")
        private String userName;

        /**
         * 小程序图片
         */
        @ApiModelProperty("小程序图片")
        private String weAppIconUrl;

    }
}
