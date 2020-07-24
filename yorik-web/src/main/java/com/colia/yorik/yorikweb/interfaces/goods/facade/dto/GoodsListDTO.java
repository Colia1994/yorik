package com.colia.yorik.yorikweb.interfaces.goods.facade.dto;

import com.colia.yorik.yorikcommon.interfaces.dto.PageInfoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsListDTO extends PageInfoDTO<GoodsDetailDTO> {

}
