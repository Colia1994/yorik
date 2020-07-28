package com.colia.yorik.yorikapplication.application.goods.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsBasicVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsDetailVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsRecommendVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsSearchVO;
import com.colia.yorik.yorikcommon.infrastructure.adapter.StringStrategy;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsBasicInfoGetResponse.GoodsBasicDetailResponseGoodsListItem;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsDetailResponse.GoodsDetailResponseGoodsDetailsItem;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponseListItem;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsSearchResponse.GoodsSearchResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsSearchResponse.GoodsSearchResponseGoodsListItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-28T10:53:43+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class GoodsMapperImpl implements GoodsMapper {

    @Autowired
    private StringStrategy stringStrategy;

    @Override
    public PddGoodsRecommendVO toPddGoodsRecommendVO(GoodsBasicDetailResponse response) {
        if ( response == null ) {
            return null;
        }

        PddGoodsRecommendVO pddGoodsRecommendVO = new PddGoodsRecommendVO();

        pddGoodsRecommendVO.setList( goodsBasicDetailResponseListItemListToPddGoodsDetailVOList( response.getList() ) );
        pddGoodsRecommendVO.setListId( response.getListId() );
        pddGoodsRecommendVO.setSearchId( response.getSearchId() );
        pddGoodsRecommendVO.setTotal( response.getTotal() );

        return pddGoodsRecommendVO;
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

    @Override
    public PddGoodsSearchVO toPddGoodsSearchVO(GoodsSearchResponse response) {
        if ( response == null ) {
            return null;
        }

        PddGoodsSearchVO pddGoodsSearchVO = new PddGoodsSearchVO();

        pddGoodsSearchVO.setGoodsList( goodsSearchResponseGoodsListItemListToPddGoodsDetailVOList( response.getGoodsList() ) );
        pddGoodsSearchVO.setListId( response.getListId() );
        pddGoodsSearchVO.setSearchId( response.getSearchId() );
        pddGoodsSearchVO.setTotalCount( response.getTotalCount() );

        return pddGoodsSearchVO;
    }

    protected PddGoodsDetailVO goodsBasicDetailResponseListItemToPddGoodsDetailVO(GoodsBasicDetailResponseListItem goodsBasicDetailResponseListItem) {
        if ( goodsBasicDetailResponseListItem == null ) {
            return null;
        }

        PddGoodsDetailVO pddGoodsDetailVO = new PddGoodsDetailVO();

        pddGoodsDetailVO.setCategoryId( goodsBasicDetailResponseListItem.getCategoryId() );
        pddGoodsDetailVO.setCategoryName( goodsBasicDetailResponseListItem.getCategoryName() );
        pddGoodsDetailVO.setCatId( goodsBasicDetailResponseListItem.getCatId() );
        List<Long> list = goodsBasicDetailResponseListItem.getCatIds();
        if ( list != null ) {
            pddGoodsDetailVO.setCatIds( new ArrayList<Long>( list ) );
        }
        pddGoodsDetailVO.setCouponDiscount( goodsBasicDetailResponseListItem.getCouponDiscount() );
        pddGoodsDetailVO.setCouponEndTime( goodsBasicDetailResponseListItem.getCouponEndTime() );
        pddGoodsDetailVO.setCouponMinOrderAmount( goodsBasicDetailResponseListItem.getCouponMinOrderAmount() );
        pddGoodsDetailVO.setCouponPrice( goodsBasicDetailResponseListItem.getCouponPrice() );
        pddGoodsDetailVO.setCouponRemainQuantity( goodsBasicDetailResponseListItem.getCouponRemainQuantity() );
        pddGoodsDetailVO.setCouponStartTime( goodsBasicDetailResponseListItem.getCouponStartTime() );
        pddGoodsDetailVO.setCouponTotalQuantity( goodsBasicDetailResponseListItem.getCouponTotalQuantity() );
        pddGoodsDetailVO.setCreateAt( goodsBasicDetailResponseListItem.getCreateAt() );
        pddGoodsDetailVO.setDescTxt( goodsBasicDetailResponseListItem.getDescTxt() );
        pddGoodsDetailVO.setGoodsDesc( goodsBasicDetailResponseListItem.getGoodsDesc() );
        pddGoodsDetailVO.setGoodsFactPrice( goodsBasicDetailResponseListItem.getGoodsFactPrice() );
        pddGoodsDetailVO.setGoodsGalleryUrls( stringStrategy.stringToList( goodsBasicDetailResponseListItem.getGoodsGalleryUrls() ) );
        pddGoodsDetailVO.setGoodsId( goodsBasicDetailResponseListItem.getGoodsId() );
        pddGoodsDetailVO.setGoodsImageUrl( goodsBasicDetailResponseListItem.getGoodsImageUrl() );
        pddGoodsDetailVO.setGoodsMarkPrice( goodsBasicDetailResponseListItem.getGoodsMarkPrice() );
        pddGoodsDetailVO.setGoodsName( goodsBasicDetailResponseListItem.getGoodsName() );
        pddGoodsDetailVO.setGoodsRate( goodsBasicDetailResponseListItem.getGoodsRate() );
        pddGoodsDetailVO.setGoodsThumbnailUrl( goodsBasicDetailResponseListItem.getGoodsThumbnailUrl() );
        pddGoodsDetailVO.setGoodsType( goodsBasicDetailResponseListItem.getGoodsType() );
        pddGoodsDetailVO.setHasCoupon( goodsBasicDetailResponseListItem.getHasCoupon() );
        pddGoodsDetailVO.setLgstTxt( goodsBasicDetailResponseListItem.getLgstTxt() );
        pddGoodsDetailVO.setMallId( goodsBasicDetailResponseListItem.getMallId() );
        pddGoodsDetailVO.setMallName( goodsBasicDetailResponseListItem.getMallName() );
        pddGoodsDetailVO.setMerchantType( goodsBasicDetailResponseListItem.getMerchantType() );
        pddGoodsDetailVO.setMinGroupPrice( goodsBasicDetailResponseListItem.getMinGroupPrice() );
        pddGoodsDetailVO.setMinNormalPrice( goodsBasicDetailResponseListItem.getMinNormalPrice() );
        pddGoodsDetailVO.setOptId( goodsBasicDetailResponseListItem.getOptId() );
        List<Long> list2 = goodsBasicDetailResponseListItem.getOptIds();
        if ( list2 != null ) {
            pddGoodsDetailVO.setOptIds( new ArrayList<Long>( list2 ) );
        }
        pddGoodsDetailVO.setOptName( goodsBasicDetailResponseListItem.getOptName() );
        pddGoodsDetailVO.setPromotionRate( goodsBasicDetailResponseListItem.getPromotionRate() );
        pddGoodsDetailVO.setSalesTip( goodsBasicDetailResponseListItem.getSalesTip() );
        pddGoodsDetailVO.setServTxt( goodsBasicDetailResponseListItem.getServTxt() );
        pddGoodsDetailVO.setMarketFee( goodsBasicDetailResponseListItem.getMarketFee() );
        pddGoodsDetailVO.setQrCodeImageUrl( goodsBasicDetailResponseListItem.getQrCodeImageUrl() );
        pddGoodsDetailVO.setSearchId( goodsBasicDetailResponseListItem.getSearchId() );
        pddGoodsDetailVO.setShareDesc( goodsBasicDetailResponseListItem.getShareDesc() );

        return pddGoodsDetailVO;
    }

    protected List<PddGoodsDetailVO> goodsBasicDetailResponseListItemListToPddGoodsDetailVOList(List<GoodsBasicDetailResponseListItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PddGoodsDetailVO> list1 = new ArrayList<PddGoodsDetailVO>( list.size() );
        for ( GoodsBasicDetailResponseListItem goodsBasicDetailResponseListItem : list ) {
            list1.add( goodsBasicDetailResponseListItemToPddGoodsDetailVO( goodsBasicDetailResponseListItem ) );
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

    protected List<Integer> longListToIntegerList(List<Long> list) {
        if ( list == null ) {
            return null;
        }

        List<Integer> list1 = new ArrayList<Integer>( list.size() );
        for ( Long long1 : list ) {
            list1.add( long1.intValue() );
        }

        return list1;
    }

    protected PddGoodsDetailVO goodsSearchResponseGoodsListItemToPddGoodsDetailVO(GoodsSearchResponseGoodsListItem goodsSearchResponseGoodsListItem) {
        if ( goodsSearchResponseGoodsListItem == null ) {
            return null;
        }

        PddGoodsDetailVO pddGoodsDetailVO = new PddGoodsDetailVO();

        if ( goodsSearchResponseGoodsListItem.getCategoryId() != null ) {
            pddGoodsDetailVO.setCategoryId( String.valueOf( goodsSearchResponseGoodsListItem.getCategoryId() ) );
        }
        pddGoodsDetailVO.setCategoryName( goodsSearchResponseGoodsListItem.getCategoryName() );
        List<Long> list = goodsSearchResponseGoodsListItem.getCatIds();
        if ( list != null ) {
            pddGoodsDetailVO.setCatIds( new ArrayList<Long>( list ) );
        }
        pddGoodsDetailVO.setCltCpnBatchSn( goodsSearchResponseGoodsListItem.getCltCpnBatchSn() );
        pddGoodsDetailVO.setCltCpnDiscount( goodsSearchResponseGoodsListItem.getCltCpnDiscount() );
        pddGoodsDetailVO.setCltCpnEndTime( goodsSearchResponseGoodsListItem.getCltCpnEndTime() );
        pddGoodsDetailVO.setCltCpnMinAmt( goodsSearchResponseGoodsListItem.getCltCpnMinAmt() );
        pddGoodsDetailVO.setCltCpnQuantity( goodsSearchResponseGoodsListItem.getCltCpnQuantity() );
        pddGoodsDetailVO.setCltCpnRemainQuantity( goodsSearchResponseGoodsListItem.getCltCpnRemainQuantity() );
        pddGoodsDetailVO.setCltCpnStartTime( goodsSearchResponseGoodsListItem.getCltCpnStartTime() );
        pddGoodsDetailVO.setCouponDiscount( goodsSearchResponseGoodsListItem.getCouponDiscount() );
        pddGoodsDetailVO.setCouponEndTime( goodsSearchResponseGoodsListItem.getCouponEndTime() );
        pddGoodsDetailVO.setCouponMinOrderAmount( goodsSearchResponseGoodsListItem.getCouponMinOrderAmount() );
        pddGoodsDetailVO.setCouponRemainQuantity( goodsSearchResponseGoodsListItem.getCouponRemainQuantity() );
        pddGoodsDetailVO.setCouponStartTime( goodsSearchResponseGoodsListItem.getCouponStartTime() );
        pddGoodsDetailVO.setCouponTotalQuantity( goodsSearchResponseGoodsListItem.getCouponTotalQuantity() );
        pddGoodsDetailVO.setCreateAt( goodsSearchResponseGoodsListItem.getCreateAt() );
        pddGoodsDetailVO.setDescTxt( goodsSearchResponseGoodsListItem.getDescTxt() );
        pddGoodsDetailVO.setGoodsDesc( goodsSearchResponseGoodsListItem.getGoodsDesc() );
        List<String> list1 = goodsSearchResponseGoodsListItem.getGoodsGalleryUrls();
        if ( list1 != null ) {
            pddGoodsDetailVO.setGoodsGalleryUrls( new ArrayList<String>( list1 ) );
        }
        pddGoodsDetailVO.setGoodsId( goodsSearchResponseGoodsListItem.getGoodsId() );
        pddGoodsDetailVO.setGoodsImageUrl( goodsSearchResponseGoodsListItem.getGoodsImageUrl() );
        pddGoodsDetailVO.setGoodsName( goodsSearchResponseGoodsListItem.getGoodsName() );
        pddGoodsDetailVO.setGoodsThumbnailUrl( goodsSearchResponseGoodsListItem.getGoodsThumbnailUrl() );
        pddGoodsDetailVO.setHasCoupon( goodsSearchResponseGoodsListItem.getHasCoupon() );
        pddGoodsDetailVO.setHasMallCoupon( goodsSearchResponseGoodsListItem.getHasMallCoupon() );
        pddGoodsDetailVO.setLgstTxt( goodsSearchResponseGoodsListItem.getLgstTxt() );
        pddGoodsDetailVO.setMallCouponDiscountPct( goodsSearchResponseGoodsListItem.getMallCouponDiscountPct() );
        pddGoodsDetailVO.setMallCouponEndTime( goodsSearchResponseGoodsListItem.getMallCouponEndTime() );
        pddGoodsDetailVO.setMallCouponMaxDiscountAmount( goodsSearchResponseGoodsListItem.getMallCouponMaxDiscountAmount() );
        pddGoodsDetailVO.setMallCouponMinOrderAmount( goodsSearchResponseGoodsListItem.getMallCouponMinOrderAmount() );
        pddGoodsDetailVO.setMallCouponRemainQuantity( goodsSearchResponseGoodsListItem.getMallCouponRemainQuantity() );
        pddGoodsDetailVO.setMallCouponStartTime( goodsSearchResponseGoodsListItem.getMallCouponStartTime() );
        pddGoodsDetailVO.setMallCouponTotalQuantity( goodsSearchResponseGoodsListItem.getMallCouponTotalQuantity() );
        pddGoodsDetailVO.setMallCps( goodsSearchResponseGoodsListItem.getMallCps() );
        pddGoodsDetailVO.setMallId( goodsSearchResponseGoodsListItem.getMallId() );
        pddGoodsDetailVO.setMallName( goodsSearchResponseGoodsListItem.getMallName() );
        if ( goodsSearchResponseGoodsListItem.getMerchantType() != null ) {
            pddGoodsDetailVO.setMerchantType( String.valueOf( goodsSearchResponseGoodsListItem.getMerchantType() ) );
        }
        pddGoodsDetailVO.setMinGroupPrice( goodsSearchResponseGoodsListItem.getMinGroupPrice() );
        pddGoodsDetailVO.setMinNormalPrice( goodsSearchResponseGoodsListItem.getMinNormalPrice() );
        pddGoodsDetailVO.setOnlySceneAuth( goodsSearchResponseGoodsListItem.getOnlySceneAuth() );
        if ( goodsSearchResponseGoodsListItem.getOptId() != null ) {
            pddGoodsDetailVO.setOptId( String.valueOf( goodsSearchResponseGoodsListItem.getOptId() ) );
        }
        List<Long> list2 = goodsSearchResponseGoodsListItem.getOptIds();
        if ( list2 != null ) {
            pddGoodsDetailVO.setOptIds( new ArrayList<Long>( list2 ) );
        }
        pddGoodsDetailVO.setOptName( goodsSearchResponseGoodsListItem.getOptName() );
        pddGoodsDetailVO.setPlanType( goodsSearchResponseGoodsListItem.getPlanType() );
        pddGoodsDetailVO.setPromotionRate( goodsSearchResponseGoodsListItem.getPromotionRate() );
        pddGoodsDetailVO.setSalesTip( goodsSearchResponseGoodsListItem.getSalesTip() );
        pddGoodsDetailVO.setServiceTags( longListToIntegerList( goodsSearchResponseGoodsListItem.getServiceTags() ) );
        pddGoodsDetailVO.setServTxt( goodsSearchResponseGoodsListItem.getServTxt() );
        pddGoodsDetailVO.setZsDuoId( goodsSearchResponseGoodsListItem.getZsDuoId() );
        pddGoodsDetailVO.setSearchId( goodsSearchResponseGoodsListItem.getSearchId() );

        return pddGoodsDetailVO;
    }

    protected List<PddGoodsDetailVO> goodsSearchResponseGoodsListItemListToPddGoodsDetailVOList(List<GoodsSearchResponseGoodsListItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PddGoodsDetailVO> list1 = new ArrayList<PddGoodsDetailVO>( list.size() );
        for ( GoodsSearchResponseGoodsListItem goodsSearchResponseGoodsListItem : list ) {
            list1.add( goodsSearchResponseGoodsListItemToPddGoodsDetailVO( goodsSearchResponseGoodsListItem ) );
        }

        return list1;
    }
}
