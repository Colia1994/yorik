package com.colia.yorik.yorikapplication.application.goods.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsBasicVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsListVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsListVO.PddGoodsListItemVO;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsBasicInfoGetResponse.GoodsBasicDetailResponseGoodsListItem;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponseListItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-24T17:45:13+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class GoodsVOMapperImpl implements GoodsVOMapper {

    @Override
    public PddGoodsListItemVO toPddGoodListItemVO(GoodsBasicDetailResponseListItem item) {
        if ( item == null ) {
            return null;
        }

        PddGoodsListItemVO pddGoodsListItemVO = new PddGoodsListItemVO();

        pddGoodsListItemVO.setCategoryId( item.getCategoryId() );
        pddGoodsListItemVO.setCategoryName( item.getCategoryName() );
        pddGoodsListItemVO.setCatId( item.getCatId() );
        List<Long> list = item.getCatIds();
        if ( list != null ) {
            pddGoodsListItemVO.setCatIds( new ArrayList<Long>( list ) );
        }
        pddGoodsListItemVO.setCouponDiscount( item.getCouponDiscount() );
        pddGoodsListItemVO.setCouponEndTime( item.getCouponEndTime() );
        pddGoodsListItemVO.setCouponMinOrderAmount( item.getCouponMinOrderAmount() );
        pddGoodsListItemVO.setCouponPrice( item.getCouponPrice() );
        pddGoodsListItemVO.setCouponRemainQuantity( item.getCouponRemainQuantity() );
        pddGoodsListItemVO.setCouponStartTime( item.getCouponStartTime() );
        pddGoodsListItemVO.setCouponTotalQuantity( item.getCouponTotalQuantity() );
        pddGoodsListItemVO.setCreateAt( item.getCreateAt() );
        pddGoodsListItemVO.setDescTxt( item.getDescTxt() );
        pddGoodsListItemVO.setGoodsDesc( item.getGoodsDesc() );
        pddGoodsListItemVO.setGoodsFactPrice( item.getGoodsFactPrice() );
        pddGoodsListItemVO.setGoodsGalleryUrls( item.getGoodsGalleryUrls() );
        pddGoodsListItemVO.setGoodsId( item.getGoodsId() );
        pddGoodsListItemVO.setGoodsImageUrl( item.getGoodsImageUrl() );
        pddGoodsListItemVO.setGoodsMarkPrice( item.getGoodsMarkPrice() );
        pddGoodsListItemVO.setGoodsName( item.getGoodsName() );
        pddGoodsListItemVO.setGoodsRate( item.getGoodsRate() );
        pddGoodsListItemVO.setGoodsThumbnailUrl( item.getGoodsThumbnailUrl() );
        pddGoodsListItemVO.setGoodsType( item.getGoodsType() );
        pddGoodsListItemVO.setHasCoupon( item.getHasCoupon() );
        pddGoodsListItemVO.setLgstTxt( item.getLgstTxt() );
        pddGoodsListItemVO.setMallId( item.getMallId() );
        pddGoodsListItemVO.setMallName( item.getMallName() );
        pddGoodsListItemVO.setMarketFee( item.getMarketFee() );
        pddGoodsListItemVO.setMerchantType( item.getMerchantType() );
        pddGoodsListItemVO.setMinGroupPrice( item.getMinGroupPrice() );
        pddGoodsListItemVO.setMinNormalPrice( item.getMinNormalPrice() );
        pddGoodsListItemVO.setOptId( item.getOptId() );
        List<Long> list1 = item.getOptIds();
        if ( list1 != null ) {
            pddGoodsListItemVO.setOptIds( new ArrayList<Long>( list1 ) );
        }
        pddGoodsListItemVO.setOptName( item.getOptName() );
        pddGoodsListItemVO.setPromotionRate( item.getPromotionRate() );
        pddGoodsListItemVO.setQrCodeImageUrl( item.getQrCodeImageUrl() );
        pddGoodsListItemVO.setSalesTip( item.getSalesTip() );
        pddGoodsListItemVO.setSearchId( item.getSearchId() );
        pddGoodsListItemVO.setServTxt( item.getServTxt() );
        pddGoodsListItemVO.setShareDesc( item.getShareDesc() );

        return pddGoodsListItemVO;
    }

    @Override
    public PddGoodsListVO toPddGoodsVO(GoodsBasicDetailResponse response) {
        if ( response == null ) {
            return null;
        }

        PddGoodsListVO pddGoodsListVO = new PddGoodsListVO();

        pddGoodsListVO.setList( goodsBasicDetailResponseListItemListToPddGoodsListItemVOList( response.getList() ) );
        pddGoodsListVO.setListId( response.getListId() );
        pddGoodsListVO.setSearchId( response.getSearchId() );
        pddGoodsListVO.setTotal( response.getTotal() );

        return pddGoodsListVO;
    }

    @Override
    public List<PddGoodsBasicVO> toPddGoodsBasicList(List<GoodsBasicDetailResponseGoodsListItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PddGoodsBasicVO> list1 = new ArrayList<PddGoodsBasicVO>( list.size() );
        for ( GoodsBasicDetailResponseGoodsListItem goodsBasicDetailResponseGoodsListItem : list ) {
            list1.add( goodsBasicDetailResponseGoodsListItemToPddGoodsBasicVO( goodsBasicDetailResponseGoodsListItem ) );
        }

        return list1;
    }

    protected List<PddGoodsListItemVO> goodsBasicDetailResponseListItemListToPddGoodsListItemVOList(List<GoodsBasicDetailResponseListItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PddGoodsListItemVO> list1 = new ArrayList<PddGoodsListItemVO>( list.size() );
        for ( GoodsBasicDetailResponseListItem goodsBasicDetailResponseListItem : list ) {
            list1.add( toPddGoodListItemVO( goodsBasicDetailResponseListItem ) );
        }

        return list1;
    }

    protected PddGoodsBasicVO goodsBasicDetailResponseGoodsListItemToPddGoodsBasicVO(GoodsBasicDetailResponseGoodsListItem goodsBasicDetailResponseGoodsListItem) {
        if ( goodsBasicDetailResponseGoodsListItem == null ) {
            return null;
        }

        PddGoodsBasicVO pddGoodsBasicVO = new PddGoodsBasicVO();

        pddGoodsBasicVO.setGoodsId( goodsBasicDetailResponseGoodsListItem.getGoodsId() );
        pddGoodsBasicVO.setGoodsName( goodsBasicDetailResponseGoodsListItem.getGoodsName() );
        pddGoodsBasicVO.setGoodsPic( goodsBasicDetailResponseGoodsListItem.getGoodsPic() );
        pddGoodsBasicVO.setMinGroupPrice( goodsBasicDetailResponseGoodsListItem.getMinGroupPrice() );
        pddGoodsBasicVO.setMinNormalPrice( goodsBasicDetailResponseGoodsListItem.getMinNormalPrice() );

        return pddGoodsBasicVO;
    }
}
