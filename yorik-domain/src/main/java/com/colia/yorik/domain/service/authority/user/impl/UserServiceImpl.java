package com.colia.yorik.domain.service.authority.user.impl;

import com.colia.yorik.domain.model.authority.user.SysUserEntity;
import com.colia.yorik.domain.service.authority.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author konglingyao
 * @Date 2020/8/12
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    /**
     * 根据用户名获取用户信息
     *
     * @param name 用户名
     * @return 用户信息
     */
    @Override
    public SysUserEntity getUserByUserName(String name) {
        return null;
    }
}
