package com.colia.yorik.domain.service.authority.user.impl;

import com.colia.yorik.dao.entity.SysUser;
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


//    @Resource
//    private UserRepository userRepository;

    /**
     * 根据用户名获取用户信息
     *
     * @param name 用户名
     * @return 用户信息
     */
    @Override
    public SysUser getUserByUserName(String name) {
        return null;
    }

    @Override
    public SysUser findUserByNameAndPwd(String userName, String password) {
        return new SysUser();
    }
}
