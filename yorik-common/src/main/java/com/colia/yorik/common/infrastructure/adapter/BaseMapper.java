package com.colia.yorik.common.infrastructure.adapter;

/**
 * @Author konglingyao
 * @Date 2020/9/3
 */
public interface BaseMapper {

    //            @Mapping(target = "id",expression = "java(getUUID())"),
    default Long convertMoneyUp(String money) {
        return 0L;
    }


}
