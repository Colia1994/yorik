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

    /**
     * qq小程序信息
     */
    @JsonProperty("qq_app_info")
    private QqAppInfoVO qqAppInfo;

    /**
     * schema的链接
     */
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
    private WeAppInfoVO weAppInfo;

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

    @Data
    public static class QqAppInfoVO implements ValueObject<QqAppInfoVO>{

        /**
         * 拼多多小程序id
         */
        @JsonProperty("app_id")
        private String appId;

        /**
         * Banner图
         */
        @JsonProperty("banner_url")
        private String bannerUrl;

        /**
         * 描述
         */
        @JsonProperty("desc")
        private String desc;

        /**
         * 小程序path值
         */
        @JsonProperty("page_path")
        private String pagePath;

        /**
         * 小程序icon
         */
        @JsonProperty("qq_app_icon_url")
        private String qqAppIconUrl;

        /**
         * 来源名
         */
        @JsonProperty("source_display_name")
        private String sourceDisplayName;

        /**
         * 小程序标题
         */
        @JsonProperty("title")
        private String title;

        /**
         * 用户名
         */
        @JsonProperty("user_name")
        private String userName;

        @Override
        public boolean sameValueAs(QqAppInfoVO other) {
            return false;
        }
    }

    @Data
    public static class WeAppInfoVO implements ValueObject<WeAppInfoVO>{

        /**
         * 拼多多小程序id
         */
        @JsonProperty("app_id")
        private String appId;

        /**
         * Banner图
         */
        @JsonProperty("banner_url")
        private String bannerUrl;

        /**
         * 描述
         */
        @JsonProperty("desc")
        private String desc;

        /**
         * 小程序path值
         */
        @JsonProperty("page_path")
        private String pagePath;

        /**
         * 来源名
         */
        @JsonProperty("source_display_name")
        private String sourceDisplayName;

        /**
         * 小程序标题
         */
        @JsonProperty("title")
        private String title;

        /**
         * 用户名
         */
        @JsonProperty("user_name")
        private String userName;

        /**
         * 小程序图片
         */
        @JsonProperty("we_app_icon_url")
        private String weAppIconUrl;

        @Override
        public boolean sameValueAs(WeAppInfoVO other) {
            return false;
        }
    }




}
