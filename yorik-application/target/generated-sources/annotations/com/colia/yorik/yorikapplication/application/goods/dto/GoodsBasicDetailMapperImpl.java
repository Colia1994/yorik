package com.colia.yorik.yorikapplication.application.goods.dto;

import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponseListItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-17T21:21:20+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class GoodsBasicDetailMapperImpl implements GoodsBasicDetailMapper {

    @Override
    public GoodsBasicDetailListItemDTO toDto(GoodsBasicDetailResponseListItem item) {
        if ( item == null ) {
            return null;
        }

        GoodsBasicDetailListItemDTO goodsBasicDetailListItemDTO = new GoodsBasicDetailListItemDTO();

        goodsBasicDetailListItemDTO.setCategoryId( item.getCategoryId() );
        goodsBasicDetailListItemDTO.setCategoryName( item.getCategoryName() );
        goodsBasicDetailListItemDTO.setCatId( item.getCatId() );
        List<Long> list = item.getCatIds();
        if ( list != null ) {
            goodsBasicDetailListItemDTO.setCatIds( new ArrayList<Long>( list ) );
        }
        goodsBasicDetailListItemDTO.setCouponDiscount( item.getCouponDiscount() );
        goodsBasicDetailListItemDTO.setCouponEndTime( item.getCouponEndTime() );
        goodsBasicDetailListItemDTO.setCouponMinOrderAmount( item.getCouponMinOrderAmount() );
        goodsBasicDetailListItemDTO.setCouponPrice( item.getCouponPrice() );
        goodsBasicDetailListItemDTO.setCouponRemainQuantity( item.getCouponRemainQuantity() );
        goodsBasicDetailListItemDTO.setCouponStartTime( item.getCouponStartTime() );
        goodsBasicDetailListItemDTO.setCouponTotalQuantity( item.getCouponTotalQuantity() );
        goodsBasicDetailListItemDTO.setCreateAt( item.getCreateAt() );
        goodsBasicDetailListItemDTO.setDescTxt( item.getDescTxt() );
        goodsBasicDetailListItemDTO.setGoodsDesc( item.getGoodsDesc() );
        goodsBasicDetailListItemDTO.setGoodsFactPrice( item.getGoodsFactPrice() );
        goodsBasicDetailListItemDTO.setGoodsGalleryUrls( item.getGoodsGalleryUrls() );
        goodsBasicDetailListItemDTO.setGoodsId( item.getGoodsId() );
        goodsBasicDetailListItemDTO.setGoodsImageUrl( item.getGoodsImageUrl() );
        goodsBasicDetailListItemDTO.setGoodsMarkPrice( item.getGoodsMarkPrice() );
        goodsBasicDetailListItemDTO.setGoodsName( item.getGoodsName() );
        goodsBasicDetailListItemDTO.setGoodsRate( item.getGoodsRate() );
        goodsBasicDetailListItemDTO.setGoodsThumbnailUrl( item.getGoodsThumbnailUrl() );
        goodsBasicDetailListItemDTO.setGoodsType( item.getGoodsType() );
        goodsBasicDetailListItemDTO.setHasCoupon( item.getHasCoupon() );
        goodsBasicDetailListItemDTO.setLgstTxt( item.getLgstTxt() );
        goodsBasicDetailListItemDTO.setMallId( item.getMallId() );
        goodsBasicDetailListItemDTO.setMallName( item.getMallName() );
        goodsBasicDetailListItemDTO.setMarketFee( item.getMarketFee() );
        goodsBasicDetailListItemDTO.setMerchantType( item.getMerchantType() );
        goodsBasicDetailListItemDTO.setMinGroupPrice( item.getMinGroupPrice() );
        goodsBasicDetailListItemDTO.setMinNormalPrice( item.getMinNormalPrice() );
        goodsBasicDetailListItemDTO.setOptId( item.getOptId() );
        List<Long> list1 = item.getOptIds();
        if ( list1 != null ) {
            goodsBasicDetailListItemDTO.setOptIds( new ArrayList<Long>( list1 ) );
        }
        goodsBasicDetailListItemDTO.setOptName( item.getOptName() );
        goodsBasicDetailListItemDTO.setPromotionRate( item.getPromotionRate() );
        goodsBasicDetailListItemDTO.setQrCodeImageUrl( item.getQrCodeImageUrl() );
        goodsBasicDetailListItemDTO.setSalesTip( item.getSalesTip() );
        goodsBasicDetailListItemDTO.setSearchId( item.getSearchId() );
        goodsBasicDetailListItemDTO.setServTxt( item.getServTxt() );
        goodsBasicDetailListItemDTO.setShareDesc( item.getShareDesc() );

        return goodsBasicDetailListItemDTO;
    }

    @Override
    public GoodsBasicDetailDTO toDto(GoodsBasicDetailResponse response) {
        if ( response == null ) {
            return null;
        }

        GoodsBasicDetailDTO goodsBasicDetailDTO = new GoodsBasicDetailDTO();

        goodsBasicDetailDTO.setList( goodsBasicDetailResponseListItemListToGoodsBasicDetailListItemDTOList( response.getList() ) );
        goodsBasicDetailDTO.setListId( response.getListId() );
        goodsBasicDetailDTO.setSearchId( response.getSearchId() );
        goodsBasicDetailDTO.setTotal( response.getTotal() );

        return goodsBasicDetailDTO;
    }

    protected List<GoodsBasicDetailListItemDTO> goodsBasicDetailResponseListItemListToGoodsBasicDetailListItemDTOList(List<GoodsBasicDetailResponseListItem> list) {
        if ( list == null ) {
            return null;
        }

        List<GoodsBasicDetailListItemDTO> list1 = new ArrayList<GoodsBasicDetailListItemDTO>( list.size() );
        for ( GoodsBasicDetailResponseListItem goodsBasicDetailResponseListItem : list ) {
            list1.add( toDto( goodsBasicDetailResponseListItem ) );
        }

        return list1;
    }
}
