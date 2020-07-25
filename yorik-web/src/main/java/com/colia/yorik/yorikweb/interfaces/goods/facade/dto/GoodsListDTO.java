package com.colia.yorik.yorikweb.interfaces.goods.facade.dto;

import com.colia.yorik.yorikcommon.interfaces.dto.PageInfoDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("商品列表")
public class GoodsListDTO extends PageInfoDTO<GoodsDetailDTO> {

}
