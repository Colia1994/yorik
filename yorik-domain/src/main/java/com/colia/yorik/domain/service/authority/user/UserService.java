package com.colia.yorik.domain.service.authority.user;

import com.colia.yorik.dao.entity.SysUser;

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
    SysUser getUserByUserName(String name);

    SysUser findUserByNameAndPwd(String userName, String password);


}
