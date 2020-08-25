package com.colia.yorik.yorikweb.interfaces.goods.facade.dto;

import com.colia.yorik.common.interfaces.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/8/10
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "商品类别列表")
public class GoodsCatsDTO extends BaseDTO {

    @ApiModelProperty("类目树对象")
    private List<GoodsCatDTO> goodsCatsList;


}
