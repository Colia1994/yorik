package com.colia.yorik.yorikweb.interfaces.promotion.facade.dto;

import com.colia.yorik.yorikcommon.interfaces.dto.BaseDTO;
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
@ApiModel("链接信息")
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
}
