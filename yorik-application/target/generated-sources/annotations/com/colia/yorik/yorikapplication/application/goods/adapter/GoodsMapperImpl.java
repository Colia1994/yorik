package com.colia.yorik.yorikapplication.application.goods.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsBasicVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsDetailVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsListVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsListVO.PddGoodsListItemVO;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsBasicInfoGetResponse.GoodsBasicDetailResponseGoodsListItem;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsDetailResponse.GoodsDetailResponseGoodsDetailsItem;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponseListItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-26T22:31:03+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class GoodsMapperImpl implements GoodsMapper {

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

    @Override
    public List<PddGoodsDetailVO> toPddGoodsDetailList(List<GoodsDetailResponseGoodsDetailsItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PddGoodsDetailVO> list1 = new ArrayList<PddGoodsDetailVO>( list.size() );
        for ( GoodsDetailResponseGoodsDetailsItem goodsDetailResponseGoodsDetailsItem : list ) {
            list1.add( goodsDetailResponseGoodsDetailsItemToPddGoodsDetailVO( goodsDetailResponseGoodsDetailsItem ) );
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

    protected List<Long> integerListToLongList(List<Integer> list) {
        if ( list == null ) {
            return null;
        }

        List<Long> list1 = new ArrayList<Long>( list.size() );
        for ( Integer integer : list ) {
            list1.add( integer.longValue() );
        }

        return list1;
    }

    protected PddGoodsDetailVO goodsDetailResponseGoodsDetailsItemToPddGoodsDetailVO(GoodsDetailResponseGoodsDetailsItem goodsDetailResponseGoodsDetailsItem) {
        if ( goodsDetailResponseGoodsDetailsItem == null ) {
            return null;
        }

        PddGoodsDetailVO pddGoodsDetailVO = new PddGoodsDetailVO();

        if ( goodsDetailResponseGoodsDetailsItem.getCategoryId() != null ) {
            pddGoodsDetailVO.setCategoryId( String.valueOf( goodsDetailResponseGoodsDetailsItem.getCategoryId() ) );
        }
        pddGoodsDetailVO.setCategoryName( goodsDetailResponseGoodsDetailsItem.getCategoryName() );
        if ( goodsDetailResponseGoodsDetailsItem.getCatId() != null ) {
            pddGoodsDetailVO.setCatId( String.valueOf( goodsDetailResponseGoodsDetailsItem.getCatId() ) );
        }
        pddGoodsDetailVO.setCatIds( integerListToLongList( goodsDetailResponseGoodsDetailsItem.getCatIds() ) );
        pddGoodsDetailVO.setCltCpnBatchSn( goodsDetailResponseGoodsDetailsItem.getCltCpnBatchSn() );
        pddGoodsDetailVO.setCltCpnDiscount( goodsDetailResponseGoodsDetailsItem.getCltCpnDiscount() );
        pddGoodsDetailVO.setCltCpnEndTime( goodsDetailResponseGoodsDetailsItem.getCltCpnEndTime() );
        pddGoodsDetailVO.setCltCpnMinAmt( goodsDetailResponseGoodsDetailsItem.getCltCpnMinAmt() );
        pddGoodsDetailVO.setCltCpnQuantity( goodsDetailResponseGoodsDetailsItem.getCltCpnQuantity() );
        pddGoodsDetailVO.setCltCpnRemainQuantity( goodsDetailResponseGoodsDetailsItem.getCltCpnRemainQuantity() );
        pddGoodsDetailVO.setCltCpnStartTime( goodsDetailResponseGoodsDetailsItem.getCltCpnStartTime() );
        pddGoodsDetailVO.setCouponDiscount( goodsDetailResponseGoodsDetailsItem.getCouponDiscount() );
        pddGoodsDetailVO.setCouponEndTime( goodsDetailResponseGoodsDetailsItem.getCouponEndTime() );
        pddGoodsDetailVO.setCouponMinOrderAmount( goodsDetailResponseGoodsDetailsItem.getCouponMinOrderAmount() );
        pddGoodsDetailVO.setCouponRemainQuantity( goodsDetailResponseGoodsDetailsItem.getCouponRemainQuantity() );
        pddGoodsDetailVO.setCouponStartTime( goodsDetailResponseGoodsDetailsItem.getCouponStartTime() );
        pddGoodsDetailVO.setCouponTotalQuantity( goodsDetailResponseGoodsDetailsItem.getCouponTotalQuantity() );
        pddGoodsDetailVO.setCreateAt( goodsDetailResponseGoodsDetailsItem.getCreateAt() );
        pddGoodsDetailVO.setDescTxt( goodsDetailResponseGoodsDetailsItem.getDescTxt() );
        pddGoodsDetailVO.setGoodsDesc( goodsDetailResponseGoodsDetailsItem.getGoodsDesc() );
        List<String> list1 = goodsDetailResponseGoodsDetailsItem.getGoodsGalleryUrls();
        if ( list1 != null ) {
            pddGoodsDetailVO.setGoodsGalleryUrls( new ArrayList<String>( list1 ) );
        }
        pddGoodsDetailVO.setGoodsId( goodsDetailResponseGoodsDetailsItem.getGoodsId() );
        pddGoodsDetailVO.setGoodsImageUrl( goodsDetailResponseGoodsDetailsItem.getGoodsImageUrl() );
        pddGoodsDetailVO.setGoodsName( goodsDetailResponseGoodsDetailsItem.getGoodsName() );
        pddGoodsDetailVO.setGoodsThumbnailUrl( goodsDetailResponseGoodsDetailsItem.getGoodsThumbnailUrl() );
        pddGoodsDetailVO.setHasCoupon( goodsDetailResponseGoodsDetailsItem.getHasCoupon() );
        pddGoodsDetailVO.setHasMallCoupon( goodsDetailResponseGoodsDetailsItem.getHasMallCoupon() );
        pddGoodsDetailVO.setLgstTxt( goodsDetailResponseGoodsDetailsItem.getLgstTxt() );
        pddGoodsDetailVO.setMallCouponDiscountPct( goodsDetailResponseGoodsDetailsItem.getMallCouponDiscountPct() );
        pddGoodsDetailVO.setMallCouponEndTime( goodsDetailResponseGoodsDetailsItem.getMallCouponEndTime() );
        pddGoodsDetailVO.setMallCouponMaxDiscountAmount( goodsDetailResponseGoodsDetailsItem.getMallCouponMaxDiscountAmount() );
        pddGoodsDetailVO.setMallCouponMinOrderAmount( goodsDetailResponseGoodsDetailsItem.getMallCouponMinOrderAmount() );
        pddGoodsDetailVO.setMallCouponRemainQuantity( goodsDetailResponseGoodsDetailsItem.getMallCouponRemainQuantity() );
        pddGoodsDetailVO.setMallCouponStartTime( goodsDetailResponseGoodsDetailsItem.getMallCouponStartTime() );
        pddGoodsDetailVO.setMallCouponTotalQuantity( goodsDetailResponseGoodsDetailsItem.getMallCouponTotalQuantity() );
        pddGoodsDetailVO.setMallCps( goodsDetailResponseGoodsDetailsItem.getMallCps() );
        pddGoodsDetailVO.setMallId( goodsDetailResponseGoodsDetailsItem.getMallId() );
        pddGoodsDetailVO.setMallName( goodsDetailResponseGoodsDetailsItem.getMallName() );
        if ( goodsDetailResponseGoodsDetailsItem.getMerchantType() != null ) {
            pddGoodsDetailVO.setMerchantType( String.valueOf( goodsDetailResponseGoodsDetailsItem.getMerchantType() ) );
        }
        pddGoodsDetailVO.setMinGroupPrice( goodsDetailResponseGoodsDetailsItem.getMinGroupPrice() );
        pddGoodsDetailVO.setMinNormalPrice( goodsDetailResponseGoodsDetailsItem.getMinNormalPrice() );
        pddGoodsDetailVO.setOnlySceneAuth( goodsDetailResponseGoodsDetailsItem.getOnlySceneAuth() );
        if ( goodsDetailResponseGoodsDetailsItem.getOptId() != null ) {
            pddGoodsDetailVO.setOptId( String.valueOf( goodsDetailResponseGoodsDetailsItem.getOptId() ) );
        }
        pddGoodsDetailVO.setOptIds( integerListToLongList( goodsDetailResponseGoodsDetailsItem.getOptIds() ) );
        pddGoodsDetailVO.setOptName( goodsDetailResponseGoodsDetailsItem.getOptName() );
        pddGoodsDetailVO.setPlanType( goodsDetailResponseGoodsDetailsItem.getPlanType() );
        pddGoodsDetailVO.setPromotionRate( goodsDetailResponseGoodsDetailsItem.getPromotionRate() );
        pddGoodsDetailVO.setSalesTip( goodsDetailResponseGoodsDetailsItem.getSalesTip() );
        List<Integer> list3 = goodsDetailResponseGoodsDetailsItem.getServiceTags();
        if ( list3 != null ) {
            pddGoodsDetailVO.setServiceTags( new ArrayList<Integer>( list3 ) );
        }
        pddGoodsDetailVO.setServTxt( goodsDetailResponseGoodsDetailsItem.getServTxt() );
        pddGoodsDetailVO.setZsDuoId( goodsDetailResponseGoodsDetailsItem.getZsDuoId() );
        List<String> list4 = goodsDetailResponseGoodsDetailsItem.getVideoUrls();
        if ( list4 != null ) {
            pddGoodsDetailVO.setVideoUrls( new ArrayList<String>( list4 ) );
        }

        return pddGoodsDetailVO;
    }
}
