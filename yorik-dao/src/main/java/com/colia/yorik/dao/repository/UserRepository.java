package com.colia.yorik.dao.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.colia.yorik.dao.entity.SysUser;
import com.colia.yorik.dao.entity.SysUserAuthorization;
import com.colia.yorik.dao.mapper.SysUserAuthorizationMapper;
import com.colia.yorik.dao.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/8/12
 */
@Repository
@Slf4j
public class UserRepository {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserAuthorizationMapper sysUserAuthMapper;


    /**
     * 根据用户名和密码查询用户信息
     */
    public SysUser findUserByNameAndPwd(String userName, String password) {
        return sysUserMapper.findUserByNameAndPwd(userName, password);

    }

    public SysUser loadByUserName(String userName) {

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();

        wrapper.eq("user_name", userName);
        List<SysUser> sysUserList = sysUserMapper.selectList(wrapper);
        return CollectionUtils.isEmpty(sysUserList) ? null : sysUserList.get(0);
    }

    public void saveUserInfo(SysUser sysUser, SysUserAuthorization sysUserAuth){
        sysUserMapper.insert(sysUser);
        sysUserAuth.setUserId(sysUser.getId());
        sysUserAuthMapper.insert(sysUserAuth);
    }


}
