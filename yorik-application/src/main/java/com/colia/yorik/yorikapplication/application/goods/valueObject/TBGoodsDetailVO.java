package com.colia.yorik.yorikapplication.application.goods.valueObject;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import lombok.Data;

import java.util.List;

/**
 * 淘宝客 商品详情
 *
 * @Author konglingyao
 * @Date 2020/8/4
 */
@Data
public class TBGoodsDetailVO implements ValueObject<TBGoodsDetailVO> {


    /**
     * 商品信息-叶子类目id
     */
    private Long categoryId;

    /**
     * 商品信息-叶子类目名称
     */
    private String categoryName;

    /**
     * 链接-宝贝推广链接
     */
    private String clickUrl;

    /**
     * 商品信息-佣金比率(%)
     */
    private String commissionRate;

    /**
     * 优惠券（元） 若属于预售商品，该优惠券付尾款可用，付定金不可用
     */
    private Long couponAmount;

    /**
     * 优惠券信息-优惠券结束时间
     */
    private String couponEndTime;

    /**
     * 优惠券信息-优惠券满减信息
     */
    private String couponInfo;

    /**
     * 优惠券信息-优惠券剩余量
     */
    private Long couponRemainCount;

    /**
     * 链接-宝贝+券二合一页面链接
     */
    private String couponShareUrl;

    /**
     * 优惠券信息-优惠券起用门槛，满X元可用。如：满299元减20元
     */
    private String couponStartFee;

    /**
     * 优惠券信息-优惠券开始时间
     */
    private String couponStartTime;

    /**
     * 优惠券信息-优惠券总量
     */
    private Long couponTotalCount;

    /**
     * 选品库信息
     */
    private FavoritesInfo favoritesInfo;

    /**
     * 商品信息-宝贝描述（推荐理由,不一定有）
     */
    private String itemDescription;

    /**
     * 商品信息-宝贝id
     */
    private Long itemId;

    /**
     * 拼团专用-拼团几人团
     */
    private Long jddNum;
    /**
     * 拼团专用-拼团拼成价，单位元
     */
    private String jddPrice;

    /**
     * 聚划算商品价格卖点描述
     */
    private String jhsPriceUspList;
    /**
     * 聚划算信息-聚淘结束时间
     */
    private String juOnlineEndTime;

    /**
     * 聚划算信息-聚淘开始时间
     */
    private String juOnlineStartTime;
    /**
     * 聚划算满减 -结束时间（毫秒）
     */
    private Long juPlayEndTime;
    /**
     * 聚划算满减 -结束时间（毫秒）
     */
    private Long juPlayStartTime;
    /**
     * 聚划算信息-商品预热结束时间（毫秒）
     */
    private String juPreShowEndTime;
    /**
     * 聚划算信息-商品预热开始时间（毫秒）
     */
    private String juPreShowStartTime;
    /**
     * 跨店满减信息
     */
    private String kuadianPromotionInfo;
    /**
     * 商品信息-一级类目名称
     */
    private Long levelOneCategoryId;
    /**
     * 商品信息-一级类目名称
     */
    private String levelOneCategoryName;
    /**
     * 锁住的佣金率
     */
    private String lockRate;
    /**
     * 锁佣结束时间
     */
    private Long lockRateEndTime;
    /**
     * 锁佣开始时间
     */
    private Long lockRateStartTime;
    /**
     * 猫超玩法信息-折扣条件，价格百分数存储，件数按数量存储。可以有多个折扣条件，与折扣字段对应，','分割
     */
    private String maochaoPlayConditions;
    /**
     * 猫超玩法信息-玩法类型，2:折扣(满n件折扣),5:减钱(满n元减m元)
     */
    private String maochaoPlayDiscountType;

    /**
     * 猫超玩法信息-折扣，折扣按照百分数存储，其余按照单位分存储。可以有多个折扣，','分割
     */
    private String maochaoPlayDiscounts;
    /**
     * 猫超玩法信息-活动开始时间，精确到毫秒
     */
    private String maochaoPlayEndTime;
    /**
     * 猫超玩法信息-当前是否包邮，1:是，0:否
     */
    private String maochaoPlayFreePostFee;
    /**
     * 猫超玩法信息-活动结束时间，精确到毫秒
     */
    private String maochaoPlayStartTime;
    /**
     * 多件券单品件数
     */
    private String multiCouponItemCount;
    /**
     * 多件券优惠比例
     */
    private String multiCouponZkRate;

    /**
     * 商品信息-新人价
     */
    private String newUserPrice;

    /**
     * 店铺信息-卖家昵称
     */
    private String nick;

    /**
     * 拼团专用-拼团结束时间
     */
    private String oetime;
    /**
     * 拼团专用-拼团一人价（原价)，单位元
     */
    private String origPrice;

    /**
     * 拼团专用-拼团开始时间
     */
    private String ostime;

    /**
     * 商品信息-商品主图
     */
    private String pictUrl;
    /**
     * 1聚划算满减：满N件减X元，满N件X折，满N件X元） 2天猫限时抢：前N分钟每件X元，前N分钟满N件每件X元，前N件每件X元）
     */
    private String playInfo;
    /**
     * 预售商品-定金（元）
     */
    private String presaleDeposit;
    /**
     * 预售商品-优惠信息
     */
    private String presaleDiscountFeeText;
    /**
     * 预售商品-付定金结束时间（毫秒）
     */
    private Long presaleEndTime;
    /**
     * 预售商品-付定金开始时间（毫秒）
     */
    private Long presaleStartTime;
    /**
     * 预售商品-付尾款结束时间（毫秒）
     */
    private Long presaleTailEndTime;
    /**
     * 预售商品-付尾款开始时间（毫秒）
     */
    private Long presaleTailStartTime;

    /**
     * 多件券件单价
     */
    private String priceAfterMultiCoupon;
    /**
     * 满减满折优惠（满2件打5折中值为5；满300减20中值为20）
     */
    private String promotionCondition;
    /**
     * 满减满折门槛（满2件打5折中值为2；满300减20中值为300）
     */
    private String promotionDiscount;

    /**
     * 满减满折信息
     */
    private String promotionInfo;
    /**
     * 满减满折的类型（1. 满减 2. 满折）
     */
    private String promotionType;

    /**
     * 商品信息-一口价
     */
    private String reservePrice;

    /**
     * 活动价
     */
    private String salePrice;

    /**
     * 拼团专用-拼团已售数量
     */
    private Long sellNum;

    /**
     * 店铺信息-卖家id
     */
    private Long sellerId;

    /**
     * 店铺信息-店铺名称
     */
    private String shopTitle;

    /**
     * 商品信息-商品短标题
     */
    private String shortTitle;

    /**
     * 商品信息-商品小图列表
     */
    private List<String> smallImages;

    /**
     * 拼团专用-拼团剩余库存
     */
    private Long stock;
    /**
     * 商品子标题
     */
    private String subTitle;

    /**
     * 商品信息-商品标题
     */
    private String title;
    /**
     * 天猫限时抢可售 -结束时间（毫秒）
     */
    private Long tmallPlayActivityEndTime;

    /**
     * 营销-天猫营销玩法
     */
    private String tmallPlayActivityInfo;
    /**
     * 天猫限时抢可售 -开始时间（毫秒）
     */
    private Long tmallPlayActivityStartTime;

    /**
     * 拼团专用-拼团库存数量
     */
    private Long totalStock;

    /**
     * 店铺信息-卖家类型，0表示集市，1表示商城
     */
    private Long userType;

    /**
     * 商品信息-预售数量
     */
    private Long uvSumPreSale;

    /**
     * 商品信息-30天销量
     */
    private Long volume;

    /**
     * 商品信息-商品白底图
     */
    private String whiteImage;

    /**
     * 商品信息-商品关联词
     */
    private List<Word> wordList;

    /**
     * 物料块id(测试中请勿使用)
     */
    private String xId;

    /**
     * 预售有礼-推广链接
     */
    private String ysylClickUrl;


    /**
     * 预售有礼-佣金比例（ 预售有礼活动享受的推广佣金比例，注：推广该活动有特殊分成规则，请详见：https://tbk.bbs.taobao.com/detail.html?appId=45301&postId=9334376 ）
     */
    private String ysylCommissionRate;
    /**
     * 预售有礼-预估淘礼金（元）
     */
    private String ysylTljFace;
    /**
     * 预售有礼-淘礼金发放时间
     */
    private String ysylTljSendTime;
    /**
     * 预售有礼-淘礼金使用结束时间
     */
    private String ysylTljUseEndTime;
    /**
     * 预售有礼-淘礼金使用开始时间
     */
    private String ysylTljUseStartTime;

    /**
     * 折扣价（元） 若属于预售商品，付定金时间内，折扣价=预售价
     */
    private String zkFinalPrice;

    @Data
    public static class Word implements ValueObject<Word> {
        /**
         * 链接-商品相关关联词落地页地址
         */
        private String url;

        /**
         * 商品相关的关联词
         */
        private String word;

        @Override
        public boolean sameValueAs(Word other) {
            return false;
        }
    }

    @Data
    public static class FavoritesInfo implements ValueObject<FavoritesInfo> {
        /**
         * 选品库详细信息
         */
        private List<FavoritesDetail> favoritesList;

        /**
         * 选品库总数量
         */
        private Long totalCount;

        @Override
        public boolean sameValueAs(FavoritesInfo other) {
            return false;
        }
    }

    @Data
    public static class FavoritesDetail implements ValueObject<FavoritesDetail> {
        /**
         * 选品库id
         */
        private Long favoritesId;
        /**
         * 选品库标题
         */
        private String favoritesTitle;


        @Override
        public boolean sameValueAs(FavoritesDetail other) {
            return false;
        }
    }

    @Override
    public boolean sameValueAs(TBGoodsDetailVO other) {
        return false;
    }
}
