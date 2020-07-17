package com.colia.yorik.yorikapplication.application.goods.dto;

import com.colia.yorik.yorikcommon.interfaces.dto.BaseDTO;
import com.pdd.pop.ext.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBasicDetailDTO extends BaseDTO {

    @JsonProperty("list")
    private List<GoodsBasicDetailListItemDTO> list;

    @JsonProperty("list_id")
    private String listId;

    @JsonProperty("search_id")
    private String searchId;

    @JsonProperty("total")
    private Integer total;
}
