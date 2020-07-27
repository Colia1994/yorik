package com.colia.yorik.yorikapplication.application.promotion.adapter;

import com.colia.yorik.yorikapplication.application.promotion.valueObject.PromotionVO;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPidGenerateResponse;
import org.mapstruct.Mapper;

/**
 * @Author konglingyao
 * @Date 2020/7/26
 */
@Mapper(componentModel = "spring")
public interface PromotionMapper {

    PromotionVO toPopVO(PddDdkGoodsPidGenerateResponse.PIdGenerateResponsePIdListItem item);
}
