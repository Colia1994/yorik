package com.colia.yorik.yorikapplication.application.goods.impl;

import com.colia.yorik.yorikapplication.application.goods.TaoBaoGoodsService;
import com.colia.yorik.yorikapplication.application.goods.adapter.GoodsMapper;
import com.colia.yorik.yorikapplication.application.goods.valueObject.TBGoodsRecommendVO;
import com.colia.yorik.yorikcommon.infrastructure.constant.TaoBaoConstant;
import com.colia.yorik.yorikcommon.infrastructure.exception.BizProcessException;
import com.colia.yorik.yoriksupport.utils.HttpClientUtils;
import com.colia.yorik.yoriksupport.utils.JSONUtil;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.JuItemsSearchRequest;
import com.taobao.api.response.JuItemsSearchResponse;
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
     * @param query 查询条件
     * @return 商品结果
     */
    @Override
    public TBGoodsRecommendVO getRecommend(JuItemsSearchRequest.TopItemQuery query) {
        JuItemsSearchRequest req = new JuItemsSearchRequest();
        TaobaoClient client = HttpClientUtils.getTBClient();

        query.setCurrentPage(1L);
        query.setPageSize(1L);
        query.setPid(TaoBaoConstant.PID);
//        obj1.setPostage(false);
//        obj1.setStatus(2L);
//        obj1.setTaobaoCategoryId(1000L);
//        obj1.setWord("棉签");
        req.setParamTopItemQuery(query);
        JuItemsSearchResponse rsp;
        try {
            log.info("searchJuTqgGoods:请求参数:{}", JSONUtil.transferToJson(query));
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
        return goodsMapper.toTBGoodsSearchVO(rsp.getResult());
    }
}
