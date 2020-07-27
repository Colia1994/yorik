package com.colia.yorik.yorikapplication.application.promotion.adapter;

import com.colia.yorik.yorikapplication.application.promotion.valueObject.PromotionVO;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPidGenerateResponse.PIdGenerateResponsePIdListItem;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-28T01:14:23+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class PromotionMapperImpl implements PromotionMapper {

    @Override
    public PromotionVO toPopVO(PIdGenerateResponsePIdListItem item) {
        if ( item == null ) {
            return null;
        }

        PromotionVO promotionVO = new PromotionVO();

        promotionVO.setCreateTime( item.getCreateTime() );
        promotionVO.setPidName( item.getPidName() );
        promotionVO.setPId( item.getPId() );

        return promotionVO;
    }
}
