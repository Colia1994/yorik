package com.colia.yorik.yorikweb.interfaces.goods.facade.dto;

import com.colia.yorik.yorikcommon.interfaces.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author konglingyao
 * @Date 2020/8/10
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "商品类别明细")
public class GoodsCatDTO extends BaseDTO {

    @ApiModelProperty("商品类目名称")
    private String catName;

    @ApiModelProperty("商品类目ID")
    private Long catId;

    public GoodsCatDTO(){

    }

    public GoodsCatDTO(String catName,Long catId){
        this.catName = catName;
        this.catId = catId;
    }

}
