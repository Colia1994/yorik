package com.colia.yorik.yorikapplication.application.goods.dto;

import com.colia.yorik.yorikcommon.interfaces.dto.Assembler;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@Component
public class GoodsBasicDetailDTOAssembler implements Assembler<GoodsBasicDetailDTO> {

    @Resource
    private GoodsBasicDetailMapper goodsBasicDetailMapper;

    @Override
    public GoodsBasicDetailDTO toDTO(Object objects) {
        if (Objects.isNull(objects)) {
            return null;
        }

        if (objects instanceof PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse) {
            return goodsBasicDetailMapper.toDto((PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse) objects);
        }

        return null;
    }
}
