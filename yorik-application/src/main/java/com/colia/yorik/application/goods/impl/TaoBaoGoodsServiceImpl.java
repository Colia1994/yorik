package com.colia.yorik.application.goods.impl;

import com.colia.yorik.application.goods.TaoBaoGoodsService;
import com.colia.yorik.application.goods.adapter.GoodsMapper;
import com.colia.yorik.application.goods.request.GoodsSearchRequest;
import com.colia.yorik.application.goods.valueObject.TBGoodsRecommendVO;
import com.colia.yorik.application.goods.valueObject.TBGoodsSearchVO;
import com.colia.yorik.common.infrastructure.constant.TaoBaoConstant;
import com.colia.yorik.common.infrastructure.exception.BizProcessException;
import com.colia.yorik.support.utils.HttpClientUtils;
import com.colia.yorik.support.utils.JSONUtil;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author konglingyao
 * @Date 2020/8/4
 */
@Slf4j
@Service
public class TaoBaoGoodsServiceImpl implements TaoBaoGoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 淘宝聚划算查询商品
     *
     * @param req 查询条件
     * @return 商品结果
     */
    @Override
    public TBGoodsRecommendVO getRecommend(TbkDgOptimusMaterialRequest req) {
        TaobaoClient client = HttpClientUtils.getTBClient();

        req.setPageSize(20L);
        req.setAdzoneId(123L);
        req.setPageNo(1L);
        req.setMaterialId(123L);
        req.setDeviceValue("xxx");
        req.setDeviceEncrypt("MD5");
        req.setDeviceType("IMEI");
        req.setContentId(323L);
        req.setContentSource("xxx");
        req.setItemId(33243L);
        req.setFavoritesId("123445");
        TbkDgOptimusMaterialResponse rsp;

        try {
            log.info("searchJuTqgGoods:请求参数:{}", JSONUtil.transferToString(req));
            rsp = client.execute(req);
            log.info("searchJuTqgGoods:返回参数:{}", JSONUtil.transferToString(rsp));
        } catch (ApiException e) {
            log.error("searchJuTqgGoods:接口错误");
            throw new BizProcessException("searchJuTqgGoods:接口错误", e);
        }
        if (rsp == null) {
            log.error("searchJuTqgGoods:接口返回数据为空");
            throw new BizProcessException("searchJuTqgGoods:接口返回数据为空");
        }
        return goodsMapper.toTBGoodsRecommendVO(rsp);
    }


    public TBGoodsSearchVO searchTBGoods(GoodsSearchRequest request){
        TaobaoClient client = HttpClientUtils.getTBClient();
        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();

        req.setPageSize(Long.valueOf(request.getPageSize()));
        req.setPageNo(Long.valueOf(request.getPageNo()));
        req.setPlatform(2L); //链接形式：1：PC，2：无线，默认：１
//        req.setEndTkRate(1234L); //商品筛选-淘客佣金比率上限。如：1234表示12.34%
//        req.setStartTkRate(1234L);

        req.setSort("tk_rate_des"); //排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi），价格（price）
        req.setCat("16,18"); //商品筛选-后台类目ID。用,分割，最大10个，该ID可以通过taobao.itemcats.get接口获取到
        req.setQ(request.getKeyword());
        req.setMaterialId(17004L);//不传时默认物料id=2836；如果直接对消费者投放，可使用官方个性化算法优化的搜索物料id=17004
        req.setHasCoupon(request.getWithCoupon());//优惠券筛选-是否有优惠券。true表示该商品有优惠券，false或不设置表示不限
//        req.setIp("13.2.33.4");//ip参数影响邮费获取，如果不传或者传入不准确，邮费无法精准提供
        req.setAdzoneId(TaoBaoConstant.SHORT_PID);//mm_xxx_xxx_12345678三段式的最后一段数字
        req.setNeedFreeShipment(true);//商品筛选-是否包邮。true表示包邮，false或不设置表示不限
        req.setNeedPrepay(true);//商品筛选-是否加入消费者保障。true表示加入，false或不设置表示不限
        req.setIncludePayRate30(true);//商品筛选(特定媒体支持)-成交转化是否高于行业均值。True表示大于等于，false或不设置表示不限
        req.setIncludeGoodRate(true);//商品筛选-好评率是否高于行业均值。True表示大于等于，false或不设置表示不限
        req.setIncludeRfdRate(true);//	商品筛选(特定媒体支持)-退款率是否低于行业均值。True表示大于等于，false或不设置表示不限
        req.setNpxLevel(2L);//商品筛选-牛皮癣程度。取值：1不限，2无，3轻微
//        req.setEndKaTkRate(1234L);//商品筛选-KA媒体淘客佣金比率上限。如：1234表示12.34%
//        req.setStartKaTkRate(1234L);
//        req.setDeviceEncrypt("MD5");//智能匹配-设备号加密类型：MD5
//        req.setDeviceValue("xxx");//智能匹配-设备号加密后的值（MD5加密需32位小写）
//        req.setDeviceType("IMEI");//智能匹配-设备号类型：IMEI，或者IDFA，或者UTDID（UTDID不支持MD5加密），或者OAID
//        req.setLockRateEndTime(1567440000000L);//锁佣结束时间
//        req.setLockRateStartTime(1567440000000L);
//        req.setLongitude("121.473701");//本地化业务入参-LBS信息-经度
//        req.setLatitude("31.230370");//本地化业务入参-LBS信息-纬度
//        req.setCityCode("310000");//本地化业务入参-LBS信息-国标城市码，仅支持单个请求，请求饿了么卡券物料时，该字段必填。 （详细城市ID见：https://mo.m.taobao.com/page_2020010315120200508）
//        req.setSellerIds("1,2,3,4");//商家id，仅支持饿了么卡券商家ID，支持批量请求1-100以内，多个商家ID使用英文逗号分隔
//        req.setSpecialId("2323");//	会员运营ID
//        req.setRelationId("3243");//渠道关系ID，仅适用于渠道推广场景
        TbkDgMaterialOptionalResponse rsp;
        try {
            log.info("searchGoods:请求参数:{}", JSONUtil.transferToString(req));
            rsp = client.execute(req);
            log.info("searchGoods:返回参数:{}", JSONUtil.transferToString(rsp));
        } catch (ApiException e) {
            log.error("searchGoods:接口错误");
            throw new BizProcessException("searchGoods:接口错误", e);
        }

        if (rsp == null) {
            log.error("searchGoods:接口返回数据为空");
            throw new BizProcessException("searchGoods:接口返回数据为空");
        }
        return goodsMapper.toTBGoodsSearchVO(rsp);
    }

}
