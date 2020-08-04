package com.colia.yorik.yorikapplication.application.goods.impl;

import com.colia.yorik.yorikapplication.application.goods.TaoBaoGoodsService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.JuItemsSearchRequest;
import com.taobao.api.response.JuItemsSearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author konglingyao
 * @Date 2020/8/4
 */
@Slf4j
@Service
public class TaoBaoGoodsServiceImpl implements TaoBaoGoodsService {

    private void test(){
        JuItemsSearchRequest req = new JuItemsSearchRequest();


        JuItemsSearchRequest.TopItemQuery obj1 = new JuItemsSearchRequest.TopItemQuery();
        obj1.setCurrentPage(1L);
        obj1.setPageSize(20L);
        obj1.setPid("mm_111816550_1171300302_109899450255");
//        obj1.setPostage(false);
//        obj1.setStatus(2L);
//        obj1.setTaobaoCategoryId(1000L);
//        obj1.setWord("棉签");
        req.setParamTopItemQuery(obj1);
        JuItemsSearchResponse rsp = null;
//        try {
//            rsp = client.execute(req);
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
//        System.out.println(rsp.getBody());
    }

    public static void main(String[] args){
        TaoBaoGoodsServiceImpl taoBaoGoodsService = new TaoBaoGoodsServiceImpl();
        taoBaoGoodsService.test();
    }
}
