package com.colia.yorik.yorikapplication.application.goods.dto;

import com.colia.yorik.yorikcommon.interfaces.dto.Assembler;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 商品通用dto 组装器
 * @Author konglingyao
 * @Date 2020/7/17
 */
@Component
public class GoodsBasicDetailDTOAssembler implements Assembler<GoodsBasicDetailDTO> {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public GoodsBasicDetailDTO toDTO(Object objects) {
        if (Objects.isNull(objects)) {
            return null;
        }


        //pdd
        if (objects instanceof PddGoodsListVO) {
            return goodsMapper.pddVoToDto((PddGoodsListVO) objects);
        }

        return null;
    }
}
