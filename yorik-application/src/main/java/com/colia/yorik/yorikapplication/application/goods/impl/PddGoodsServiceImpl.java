package com.colia.yorik.yorikapplication.application.goods.impl;

import com.colia.yorik.yorikapplication.application.goods.PddGoodsService;
import com.colia.yorik.yorikapplication.application.goods.dto.GoodsBasicDetailDTO;
import com.colia.yorik.yorikapplication.application.goods.dto.GoodsBasicDetailDTOAssembler;
import com.colia.yorik.yorikapplication.application.goods.dto.GoodsMapper;
import com.colia.yorik.yorikapplication.application.goods.dto.PddGoodsListVO;
import com.colia.yorik.yorikcommon.infrastructure.exception.BizProcessException;
import com.colia.yorik.yoriksupport.utils.HttpPddClient;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsBasicInfoGetRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsDetailRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsRecommendGetRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsBasicInfoGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsDetailResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@Service
public class PddGoodsServiceImpl implements PddGoodsService {
    @Resource
    private GoodsBasicDetailDTOAssembler goodsBasicDetailDTOAssembler;

    @Resource
    private GoodsMapper goodsMapper;


    @Override
    public GoodsBasicDetailDTO getRecommendGoods() {
        PopClient client = HttpPddClient.getPddClient();

        PddDdkGoodsRecommendGetRequest request = new PddDdkGoodsRecommendGetRequest();
        request.setChannelType(0);
        request.setLimit(10);
        request.setOffset(0);
        PddDdkGoodsRecommendGetResponse response;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            throw new BizProcessException("PDD推荐商品接口异常", e);
        }
        System.out.println(JsonUtil.transferToJson(response));
        PddGoodsListVO listVO = goodsMapper.toPddGoodsVO(response.getGoodsBasicDetailResponse());
        return goodsBasicDetailDTOAssembler.toDTO(listVO);
    }

    @Override
    public void getGoodsBasicInfo() {
        PopClient client = HttpPddClient.getPddClient();

        PddDdkGoodsBasicInfoGetRequest request = new PddDdkGoodsBasicInfoGetRequest();
        List<Long> goodsIdList = new ArrayList<>();

        goodsIdList.add(0L);
        request.setGoodsIdList(goodsIdList);
        PddDdkGoodsBasicInfoGetResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            throw new BizProcessException("PDD获取商品详情接口异常", e);
        }
        System.out.println(JsonUtil.transferToJson(response));
    }

    void getGoodsDetailInfo(List<Long> goodsIdList){
        PopClient client = HttpPddClient.getPddClient();

        PddDdkGoodsDetailRequest request = new PddDdkGoodsDetailRequest();
        request.setCustomParameters("str");
        request.setGoodsIdList(goodsIdList);
        request.setPid("str");
        request.setPlanType(0);
        request.setSearchId("str");
        request.setZsDuoId(0L);
        PddDdkGoodsDetailResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JsonUtil.transferToJson(response));
    }
}
