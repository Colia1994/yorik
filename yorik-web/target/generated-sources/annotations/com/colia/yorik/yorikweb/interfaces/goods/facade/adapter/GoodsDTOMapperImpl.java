package com.colia.yorik.yorikweb.interfaces.goods.facade.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsDetailVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsRecommendVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsSearchVO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-28T10:53:45+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class GoodsDTOMapperImpl implements GoodsDTOMapper {

    @Override
    public GoodsListDTO pddVoToDto(PddGoodsSearchVO item) {
        if ( item == null ) {
            return null;
        }

        GoodsListDTO goodsListDTO = new GoodsListDTO();

        goodsListDTO.setRecords( pddGoodsDetailVOListToGoodsDetailDTOList( item.getGoodsList() ) );
        goodsListDTO.setTotal( item.getTotalCount() );
        goodsListDTO.setListId( item.getListId() );
        goodsListDTO.setSearchId( item.getSearchId() );

        return goodsListDTO;
    }

    @Override
    public GoodsListDTO pddVoToDto(PddGoodsRecommendVO listVO) {
        if ( listVO == null ) {
            return null;
        }

        GoodsListDTO goodsListDTO = new GoodsListDTO();

        goodsListDTO.setRecords( pddGoodsDetailVOListToGoodsDetailDTOList( listVO.getList() ) );
        goodsListDTO.setListId( listVO.getListId() );
        goodsListDTO.setTotal( listVO.getTotal() );
        goodsListDTO.setSearchId( listVO.getSearchId() );

        return goodsListDTO;
    }

    @Override
    public GoodsDetailDTO pddVoToDto(PddGoodsDetailVO item) {
        if ( item == null ) {
            return null;
        }

        GoodsDetailDTO goodsDetailDTO = new GoodsDetailDTO();

        goodsDetailDTO.setCategoryId( item.getCategoryId() );
        goodsDetailDTO.setCategoryName( item.getCategoryName() );
        goodsDetailDTO.setCatId( item.getCatId() );
        List<Long> list = item.getCatIds();
        if ( list != null ) {
            goodsDetailDTO.setCatIds( new ArrayList<Long>( list ) );
        }
        goodsDetailDTO.setCouponDiscount( item.getCouponDiscount() );
        goodsDetailDTO.setCouponEndTime( item.getCouponEndTime() );
        goodsDetailDTO.setCouponMinOrderAmount( item.getCouponMinOrderAmount() );
        goodsDetailDTO.setCouponPrice( item.getCouponPrice() );
        goodsDetailDTO.setCouponRemainQuantity( item.getCouponRemainQuantity() );
        goodsDetailDTO.setCouponStartTime( item.getCouponStartTime() );
        goodsDetailDTO.setCouponTotalQuantity( item.getCouponTotalQuantity() );
        goodsDetailDTO.setGoodsDesc( item.getGoodsDesc() );
        List<String> list1 = item.getGoodsGalleryUrls();
        if ( list1 != null ) {
            goodsDetailDTO.setGoodsGalleryUrls( new ArrayList<String>( list1 ) );
        }
        goodsDetailDTO.setGoodsId( item.getGoodsId() );
        goodsDetailDTO.setGoodsImageUrl( item.getGoodsImageUrl() );
        goodsDetailDTO.setGoodsFactPrice( item.getGoodsFactPrice() );
        goodsDetailDTO.setGoodsMarkPrice( item.getGoodsMarkPrice() );
        goodsDetailDTO.setGoodsName( item.getGoodsName() );
        goodsDetailDTO.setGoodsRate( item.getGoodsRate() );
        goodsDetailDTO.setGoodsThumbnailUrl( item.getGoodsThumbnailUrl() );
        goodsDetailDTO.setGoodsType( item.getGoodsType() );
        goodsDetailDTO.setHasCoupon( item.getHasCoupon() );
        goodsDetailDTO.setMallId( item.getMallId() );
        goodsDetailDTO.setMallName( item.getMallName() );
        goodsDetailDTO.setMarketFee( item.getMarketFee() );
        goodsDetailDTO.setMerchantType( item.getMerchantType() );
        goodsDetailDTO.setMinGroupPrice( item.getMinGroupPrice() );
        goodsDetailDTO.setMinNormalPrice( item.getMinNormalPrice() );
        goodsDetailDTO.setOptId( item.getOptId() );
        List<Long> list2 = item.getOptIds();
        if ( list2 != null ) {
            goodsDetailDTO.setOptIds( new ArrayList<Long>( list2 ) );
        }
        goodsDetailDTO.setOptName( item.getOptName() );
        goodsDetailDTO.setQrCodeImageUrl( item.getQrCodeImageUrl() );
        goodsDetailDTO.setSalesTip( item.getSalesTip() );
        goodsDetailDTO.setSearchId( item.getSearchId() );
        goodsDetailDTO.setShareDesc( item.getShareDesc() );
        goodsDetailDTO.setPromotionRate( item.getPromotionRate() );

        return goodsDetailDTO;
    }

    protected List<GoodsDetailDTO> pddGoodsDetailVOListToGoodsDetailDTOList(List<PddGoodsDetailVO> list) {
        if ( list == null ) {
            return null;
        }

        List<GoodsDetailDTO> list1 = new ArrayList<GoodsDetailDTO>( list.size() );
        for ( PddGoodsDetailVO pddGoodsDetailVO : list ) {
            list1.add( pddVoToDto( pddGoodsDetailVO ) );
        }

        return list1;
    }
}
