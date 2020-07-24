package com.colia.yorik.yorikapplication.application.goods.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsDetailVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsListVO;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponseListItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-24T17:02:37+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class GoodsVOMapperImpl implements GoodsVOMapper {

    @Override
    public PddGoodsDetailVO toPddGoodDetailVO(GoodsBasicDetailResponseListItem item) {
        if ( item == null ) {
            return null;
        }

        PddGoodsDetailVO pddGoodsDetailVO = new PddGoodsDetailVO();

        pddGoodsDetailVO.setCategoryId( item.getCategoryId() );
        pddGoodsDetailVO.setCategoryName( item.getCategoryName() );
        pddGoodsDetailVO.setCatId( item.getCatId() );
        List<Long> list = item.getCatIds();
        if ( list != null ) {
            pddGoodsDetailVO.setCatIds( new ArrayList<Long>( list ) );
        }
        pddGoodsDetailVO.setCouponDiscount( item.getCouponDiscount() );
        pddGoodsDetailVO.setCouponEndTime( item.getCouponEndTime() );
        pddGoodsDetailVO.setCouponMinOrderAmount( item.getCouponMinOrderAmount() );
        pddGoodsDetailVO.setCouponPrice( item.getCouponPrice() );
        pddGoodsDetailVO.setCouponRemainQuantity( item.getCouponRemainQuantity() );
        pddGoodsDetailVO.setCouponStartTime( item.getCouponStartTime() );
        pddGoodsDetailVO.setCouponTotalQuantity( item.getCouponTotalQuantity() );
        pddGoodsDetailVO.setCreateAt( item.getCreateAt() );
        pddGoodsDetailVO.setDescTxt( item.getDescTxt() );
        pddGoodsDetailVO.setGoodsDesc( item.getGoodsDesc() );
        pddGoodsDetailVO.setGoodsFactPrice( item.getGoodsFactPrice() );
        pddGoodsDetailVO.setGoodsGalleryUrls( item.getGoodsGalleryUrls() );
        pddGoodsDetailVO.setGoodsId( item.getGoodsId() );
        pddGoodsDetailVO.setGoodsImageUrl( item.getGoodsImageUrl() );
        pddGoodsDetailVO.setGoodsMarkPrice( item.getGoodsMarkPrice() );
        pddGoodsDetailVO.setGoodsName( item.getGoodsName() );
        pddGoodsDetailVO.setGoodsRate( item.getGoodsRate() );
        pddGoodsDetailVO.setGoodsThumbnailUrl( item.getGoodsThumbnailUrl() );
        pddGoodsDetailVO.setGoodsType( item.getGoodsType() );
        pddGoodsDetailVO.setHasCoupon( item.getHasCoupon() );
        pddGoodsDetailVO.setLgstTxt( item.getLgstTxt() );
        pddGoodsDetailVO.setMallId( item.getMallId() );
        pddGoodsDetailVO.setMallName( item.getMallName() );
        pddGoodsDetailVO.setMarketFee( item.getMarketFee() );
        pddGoodsDetailVO.setMerchantType( item.getMerchantType() );
        pddGoodsDetailVO.setMinGroupPrice( item.getMinGroupPrice() );
        pddGoodsDetailVO.setMinNormalPrice( item.getMinNormalPrice() );
        pddGoodsDetailVO.setOptId( item.getOptId() );
        List<Long> list1 = item.getOptIds();
        if ( list1 != null ) {
            pddGoodsDetailVO.setOptIds( new ArrayList<Long>( list1 ) );
        }
        pddGoodsDetailVO.setOptName( item.getOptName() );
        pddGoodsDetailVO.setPromotionRate( item.getPromotionRate() );
        pddGoodsDetailVO.setQrCodeImageUrl( item.getQrCodeImageUrl() );
        pddGoodsDetailVO.setSalesTip( item.getSalesTip() );
        pddGoodsDetailVO.setSearchId( item.getSearchId() );
        pddGoodsDetailVO.setServTxt( item.getServTxt() );
        pddGoodsDetailVO.setShareDesc( item.getShareDesc() );

        return pddGoodsDetailVO;
    }

    @Override
    public PddGoodsListVO toPddGoodsVO(GoodsBasicDetailResponse response) {
        if ( response == null ) {
            return null;
        }

        PddGoodsListVO pddGoodsListVO = new PddGoodsListVO();

        pddGoodsListVO.setList( goodsBasicDetailResponseListItemListToPddGoodsDetailVOList( response.getList() ) );
        pddGoodsListVO.setListId( response.getListId() );
        pddGoodsListVO.setSearchId( response.getSearchId() );
        pddGoodsListVO.setTotal( response.getTotal() );

        return pddGoodsListVO;
    }

    protected List<PddGoodsDetailVO> goodsBasicDetailResponseListItemListToPddGoodsDetailVOList(List<GoodsBasicDetailResponseListItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PddGoodsDetailVO> list1 = new ArrayList<PddGoodsDetailVO>( list.size() );
        for ( GoodsBasicDetailResponseListItem goodsBasicDetailResponseListItem : list ) {
            list1.add( toPddGoodDetailVO( goodsBasicDetailResponseListItem ) );
        }

        return list1;
    }
}
