package com.colia.yorik.yorikapplication.application.goods.impl;

import com.colia.yorik.yorikapplication.application.goods.RecommendGoodsService;
import com.colia.yorik.yorikapplication.application.goods.dto.GoodsBasicDetailDTO;
import com.colia.yorik.yorikapplication.application.goods.dto.GoodsBasicDetailDTOAssembler;
import com.colia.yorik.yorikapplication.application.goods.dto.GoodsMapper;
import com.colia.yorik.yorikapplication.application.goods.dto.PddGoodsListVO;
import com.colia.yorik.yorikcommon.infrastructure.exception.BizProcessException;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsRecommendGetRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@Service
public class RecommendGoodsServiceImpl implements RecommendGoodsService {
    @Resource
    private GoodsBasicDetailDTOAssembler goodsBasicDetailDTOAssembler;

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public GoodsBasicDetailDTO getRecommendGoods(String clientId, String clientSecret) {
        PopClient client = new PopHttpClient(clientId, clientSecret);

        PddDdkGoodsRecommendGetRequest request = new PddDdkGoodsRecommendGetRequest();
        request.setChannelType(0);
        request.setLimit(10);
        request.setOffset(0);
        PddDdkGoodsRecommendGetResponse response;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            throw new BizProcessException("", e);
        }
        System.out.println(JsonUtil.transferToJson(response));
        PddGoodsListVO listVO = goodsMapper.toPddGoodsVO(response.getGoodsBasicDetailResponse());
        return goodsBasicDetailDTOAssembler.toDTO(response.getGoodsBasicDetailResponse());
    }
}
