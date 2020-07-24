package com.colia.yorik.yorikweb.interfaces.goods.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsDetailVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsListVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsListVO.PddGoodsListItemVO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-24T17:45:15+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class GoodsDTOMapperImpl implements GoodsDTOMapper {

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
        goodsDetailDTO.setGoodsGalleryUrls( item.getGoodsGalleryUrls() );
        goodsDetailDTO.setGoodsId( item.getGoodsId() );
        goodsDetailDTO.setGoodsImageUrl( item.getGoodsImageUrl() );
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
        List<Long> list1 = item.getOptIds();
        if ( list1 != null ) {
            goodsDetailDTO.setOptIds( new ArrayList<Long>( list1 ) );
        }
        goodsDetailDTO.setOptName( item.getOptName() );
        goodsDetailDTO.setQrCodeImageUrl( item.getQrCodeImageUrl() );
        goodsDetailDTO.setSalesTip( item.getSalesTip() );
        goodsDetailDTO.setSearchId( item.getSearchId() );
        goodsDetailDTO.setShareDesc( item.getShareDesc() );

        return goodsDetailDTO;
    }

    @Override
    public GoodsListDTO pddVoToDto(PddGoodsListVO listVO) {
        if ( listVO == null ) {
            return null;
        }

        GoodsListDTO goodsListDTO = new GoodsListDTO();

        goodsListDTO.setRecords( pddGoodsListItemVOListToGoodsDetailDTOList( listVO.getList() ) );
        goodsListDTO.setListId( listVO.getListId() );
        goodsListDTO.setTotal( listVO.getTotal() );

        return goodsListDTO;
    }

    protected GoodsDetailDTO pddGoodsListItemVOToGoodsDetailDTO(PddGoodsListItemVO pddGoodsListItemVO) {
        if ( pddGoodsListItemVO == null ) {
            return null;
        }

        GoodsDetailDTO goodsDetailDTO = new GoodsDetailDTO();

        goodsDetailDTO.setCategoryId( pddGoodsListItemVO.getCategoryId() );
        goodsDetailDTO.setCategoryName( pddGoodsListItemVO.getCategoryName() );
        goodsDetailDTO.setCatId( pddGoodsListItemVO.getCatId() );
        List<Long> list = pddGoodsListItemVO.getCatIds();
        if ( list != null ) {
            goodsDetailDTO.setCatIds( new ArrayList<Long>( list ) );
        }
        goodsDetailDTO.setCouponDiscount( pddGoodsListItemVO.getCouponDiscount() );
        goodsDetailDTO.setCouponEndTime( pddGoodsListItemVO.getCouponEndTime() );
        goodsDetailDTO.setCouponMinOrderAmount( pddGoodsListItemVO.getCouponMinOrderAmount() );
        goodsDetailDTO.setCouponPrice( pddGoodsListItemVO.getCouponPrice() );
        goodsDetailDTO.setCouponRemainQuantity( pddGoodsListItemVO.getCouponRemainQuantity() );
        goodsDetailDTO.setCouponStartTime( pddGoodsListItemVO.getCouponStartTime() );
        goodsDetailDTO.setCouponTotalQuantity( pddGoodsListItemVO.getCouponTotalQuantity() );
        goodsDetailDTO.setGoodsDesc( pddGoodsListItemVO.getGoodsDesc() );
        goodsDetailDTO.setGoodsGalleryUrls( pddGoodsListItemVO.getGoodsGalleryUrls() );
        goodsDetailDTO.setGoodsId( pddGoodsListItemVO.getGoodsId() );
        goodsDetailDTO.setGoodsImageUrl( pddGoodsListItemVO.getGoodsImageUrl() );
        goodsDetailDTO.setGoodsMarkPrice( pddGoodsListItemVO.getGoodsMarkPrice() );
        goodsDetailDTO.setGoodsName( pddGoodsListItemVO.getGoodsName() );
        goodsDetailDTO.setGoodsRate( pddGoodsListItemVO.getGoodsRate() );
        goodsDetailDTO.setGoodsThumbnailUrl( pddGoodsListItemVO.getGoodsThumbnailUrl() );
        goodsDetailDTO.setGoodsType( pddGoodsListItemVO.getGoodsType() );
        goodsDetailDTO.setHasCoupon( pddGoodsListItemVO.getHasCoupon() );
        goodsDetailDTO.setMallId( pddGoodsListItemVO.getMallId() );
        goodsDetailDTO.setMallName( pddGoodsListItemVO.getMallName() );
        goodsDetailDTO.setMarketFee( pddGoodsListItemVO.getMarketFee() );
        goodsDetailDTO.setMerchantType( pddGoodsListItemVO.getMerchantType() );
        goodsDetailDTO.setMinGroupPrice( pddGoodsListItemVO.getMinGroupPrice() );
        goodsDetailDTO.setMinNormalPrice( pddGoodsListItemVO.getMinNormalPrice() );
        goodsDetailDTO.setOptId( pddGoodsListItemVO.getOptId() );
        List<Long> list1 = pddGoodsListItemVO.getOptIds();
        if ( list1 != null ) {
            goodsDetailDTO.setOptIds( new ArrayList<Long>( list1 ) );
        }
        goodsDetailDTO.setOptName( pddGoodsListItemVO.getOptName() );
        goodsDetailDTO.setQrCodeImageUrl( pddGoodsListItemVO.getQrCodeImageUrl() );
        goodsDetailDTO.setSalesTip( pddGoodsListItemVO.getSalesTip() );
        goodsDetailDTO.setSearchId( pddGoodsListItemVO.getSearchId() );
        goodsDetailDTO.setShareDesc( pddGoodsListItemVO.getShareDesc() );

        return goodsDetailDTO;
    }

    protected List<GoodsDetailDTO> pddGoodsListItemVOListToGoodsDetailDTOList(List<PddGoodsListItemVO> list) {
        if ( list == null ) {
            return null;
        }

        List<GoodsDetailDTO> list1 = new ArrayList<GoodsDetailDTO>( list.size() );
        for ( PddGoodsListItemVO pddGoodsListItemVO : list ) {
            list1.add( pddGoodsListItemVOToGoodsDetailDTO( pddGoodsListItemVO ) );
        }

        return list1;
    }
}
