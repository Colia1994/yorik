package com.colia.yorik.yorikapplication.application.goods.impl;

import com.colia.yorik.yorikapplication.application.goods.TaoBaoGoodsService;
import com.colia.yorik.yorikapplication.application.goods.adapter.GoodsMapper;
import com.colia.yorik.yorikapplication.application.goods.valueObject.TBGoodsRecommendVO;
import com.colia.yorik.yorikcommon.infrastructure.exception.BizProcessException;
import com.colia.yorik.yoriksupport.utils.HttpClientUtils;
import com.colia.yorik.yoriksupport.utils.JSONUtil;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
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
            log.info("searchJuTqgGoods:请求参数:{}", JSONUtil.transferToJson(req));
            rsp = client.execute(req);
            log.info("searchJuTqgGoods:返回参数:{}", JSONUtil.transferToJson(rsp));
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
}
