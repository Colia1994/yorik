package com.colia.yorik.yorikweb.interfaces.goods.facade.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddCatsVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsDetailVO;
import com.colia.yorik.yorikcommon.interfaces.dto.Assembler;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsCatsDTO;
import com.pdd.pop.sdk.http.api.pop.response.PddGoodsCatsGetResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Author konglingyao
 * @Date 2020/8/10
 */
@Component
public class GoodsCatsDTOAssembler  implements Assembler<GoodsCatsDTO> {
    @Resource
    private GoodsCommonMapper goodsCommonMapper;

    @Override
    public GoodsCatsDTO toDTO(Object objects) {
        if (Objects.isNull(objects)) {
            return null;
        }

        //pdd
        if (objects instanceof PddCatsVO) {
            return goodsCommonMapper.pddToCatsDTO((PddCatsVO) objects);
        }

        return null;
    }
}
