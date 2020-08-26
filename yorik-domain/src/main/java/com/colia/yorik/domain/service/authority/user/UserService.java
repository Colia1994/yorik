package com.colia.yorik.domain.service.authority.user;

import com.colia.yorik.domain.model.authority.user.SysUserEntity;

/**
 * @Author konglingyao
 * @Date 2020/8/12
 */
public interface UserService {

    /**
     * 根据用户名获取用户信息
     *
     * @param name 用户名
     * @return 用户信息
     */
    SysUserEntity getUserByUserName(String name);
}
