package com.colia.yorik.support.application.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @Author konglingyao
 * @Date 2021/4/16
 */
public enum IdentityTypeEnum implements IEnum<Integer> {


    ACCOUNT_PASSWORD(1, "账号密码"),
    PHONE_PASSWORD(2, "手机密码");


    private final Integer type;


    private final String name;

    IdentityTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }


    @Override
    public Integer getValue() {
        return type;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
