package com.colia.yorik.web.interfaces.goods.facade.adapter;

import com.colia.yorik.application.goods.valueObject.PddGoodsDetailVO;
import com.colia.yorik.support.interfaces.dto.Assembler;
import com.colia.yorik.web.interfaces.goods.facade.dto.GoodsDetailDTO;
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
public class GoodsDetailDTOAssembler implements Assembler<GoodsDetailDTO> {

    @Resource
    private GoodsDTOMapper goodsDTOMapper;

    @Override
    public GoodsDetailDTO toDTO(Object objects) {
        if (Objects.isNull(objects)) {
            return null;
        }


        //pdd
        if (objects instanceof PddGoodsDetailVO) {
            return goodsDTOMapper.pddVOToDTO((PddGoodsDetailVO) objects);
        }

        return null;
    }


}
