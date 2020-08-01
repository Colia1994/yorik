package com.colia.yorik.yorikweb.interfaces.promotion.facade.adapter;

import com.colia.yorik.yorikapplication.application.promotion.valueObject.PddUrlVO;
import com.colia.yorik.yorikweb.interfaces.promotion.facade.dto.UrlDTO;
import org.mapstruct.Mapper;

/**
 * @Author konglingyao
 * @Date 2020/7/31
 */
@Mapper(componentModel = "spring")
public interface UrlDTOMapper {

    UrlDTO pddVOToDto(PddUrlVO vo);
}
