package com.colia.yorik.yorikapplication.application.promotion.valueObject;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import com.pdd.pop.ext.fasterxml.jackson.annotation.JsonProperty;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPromotionUrlGenerateResponse;
import lombok.Data;

/**
 * 多多进宝推广链接对象列表
 *
 * @Author konglingyao
 * @Date 2020/7/29
 */
@Data
public class PddUrlVO implements ValueObject<PddUrlVO> {

    /**
     * 唤醒拼多多app的推广短链接
     */
    @JsonProperty("mobile_short_url")
    private String mobileShortUrl;

    /**
     * 唤醒拼多多app的推广长链接
     */
    @JsonProperty("mobile_url")
    private String mobileUrl;

    @JsonProperty("qq_app_info")
    private PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItemQqAppInfo qqAppInfo;
    @JsonProperty("schema_url")
    private String schemaUrl;

    /**
     * 推广短链接
     */
    @JsonProperty("short_url")
    private String shortUrl;

    /**
     * 推广长链接
     */
    @JsonProperty("url")
    private String url;

    /**
     * 微博推广短链接
     */
    @JsonProperty("weibo_app_web_view_short_url")
    private String weiboAppWebViewShortUrl;

    /**
     * 微博推广链接
     */
    @JsonProperty("weibo_app_web_view_url")
    private String weiboAppWebViewUrl;

    /**
     * 小程序信息
     */
    @JsonProperty("we_app_info")
    private PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItemWeAppInfo weAppInfo;

    /**
     * 	唤起微信app推广短链接
     */
    @JsonProperty("we_app_web_view_short_url")
    private String weAppWebViewShortUrl;

    /**
     * 唤起微信app推广链接
     */
    @JsonProperty("we_app_web_view_url")
    private String weAppWebViewUrl;


    @Override
    public boolean sameValueAs(PddUrlVO other) {
        return false;
    }



}
