package com.colia.yorik.domain.model.authority.user;

import lombok.Data;

/**
 * @Author konglingyao
 * @Date 2020/8/12
 */
@Data
public class SysUserEntity {

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号码 11位 不带区号
     */
    private String phoneNum;

    /**
     * 密码
     */
    private String password;




}
