package com.colia.yorik.yorikweb.interfaces.goods.facade.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsRecommendVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsSearchVO;
import com.colia.yorik.yorikcommon.interfaces.dto.Assembler;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 商品通用dto 组装器
 *
 * @Author konglingyao
 * @Date 2020/7/17
 */
@Component
public class GoodsListDTOAssembler implements Assembler<GoodsListDTO> {

    @Resource
    private GoodsDTOMapper goodsDTOMapper;

    @Override
    public GoodsListDTO toDTO(Object objects) {
        if (Objects.isNull(objects)) {
            return null;
        }


        //pdd
        if (objects instanceof PddGoodsRecommendVO) {
            return goodsDTOMapper.pddVoToDto((PddGoodsRecommendVO) objects);
        } else if (objects instanceof PddGoodsSearchVO) {
            return goodsDTOMapper.pddVoToDto((PddGoodsSearchVO) objects);

        }

        return null;
    }


}