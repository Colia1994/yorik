package com.colia.yorik.yorikweb.interfaces.goods.facade.request;

import com.colia.yorik.yorikcommon.interfaces.requestBody.PageCommand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "搜索商品请求参数")
public class GoodsSearchRequest extends PageCommand {

    @ApiModelProperty("商品活动标记数组，例：[4,7]，4-秒杀 7-百亿补贴等")
    private List<Integer> activityTags;

    @ApiModelProperty("商品类目id")
    private Long catId;

    @ApiModelProperty("goods_id_list")
    private List<Long> goodsIdList;

    @ApiModelProperty("是否为品牌商品")
    private Boolean isBrandGoods;

    @ApiModelProperty("商品关键词，与opt_id字段选填一个或全部填写")
    private String keyword;

    @ApiModelProperty("店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店（未传为全部")
    private Integer merchantType;

    @ApiModelProperty("店铺类型数组")
    private List<Integer> merchantTypeList;

    @ApiModelProperty("商品标签类目ID")
    private Long optId;

    @ApiModelProperty("推广位id")
    private String pid;

    @ApiModelProperty("range_list")
    private List<GoodsSearchRequest.RangeListItem> rangeList;
    @ApiModelProperty("排序方式:0-综合排序;1-按佣金比率升序;2-按佣金比例降序;3-按价格升序;4-按价格降序;5-按销量升序;6-按销量降序;7-优惠券金额排序升序;8-优惠券金额排序降序;9-券后价升序排序;10-券后价降序排序;11-按照加入多多进宝时间升序;12-按照加入多多进宝时间降序;13-按佣金金额升序排序;14-按佣金金额降序排序;15-店铺描述评分升序;16-店铺描述评分降序;17-店铺物流评分升序;18-店铺物流评分降序;19-店铺服务评分升序;20-店铺服务评分降序;27-描述评分击败同类店铺百分比升序，28-描述评分击败同类店铺百分比降序，29-物流评分击败同类店铺百分比升序，30-物流评分击败同类店铺百分比降序，31-服务评分击败同类店铺百分比升序，32-服务评分击败同类店铺百分比降序")
    private Integer sortType;

    @ApiModelProperty("是否只返回优惠券的商品，false返回所有商品，true只返回有优惠券的商品")
    private Boolean withCoupon;


    /**
     * 指令验证
     */
    @Override
    public void validate() {

    }

    @Data
    public static class RangeListItem {
        @ApiModelProperty("区间的开始值")
        private Long rangeFrom;
        @ApiModelProperty("0，最小成团价 1，券后价 2，佣金比例 3，优惠券价格 4，广告创建时间 5，销量 6，佣金金额 7，店铺描述分 8，店铺物流分 9，店铺服务分 10， 店铺描述分击败同行业百分比 11， 店铺物流分击败同行业百分比 12，店铺服务分击败同行业百分比 13，商品分 17 ，优惠券/最小团购价 18，过去两小时pv 19，过去两小时销量")
        private Integer rangeId;
        @ApiModelProperty("区间的结束值")
        private Long rangeTo;
    }
}
