package com.colia.yorik.application.goods.adapter;

import com.colia.yorik.application.goods.valueObject.PddCatsVO;
import com.pdd.pop.sdk.http.api.pop.response.PddGoodsCatsGetResponse;
import org.mapstruct.Mapper;

/**
 * @Author konglingyao
 * @Date 2020/8/10
 */
@Mapper(componentModel = "spring")
public interface CatsMapper {

    PddCatsVO toPddCats(PddGoodsCatsGetResponse.GoodsCatsGetResponse item);
}
