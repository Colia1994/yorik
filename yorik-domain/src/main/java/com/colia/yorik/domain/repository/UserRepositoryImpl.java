package com.colia.yorik.domain.repository;


import com.colia.yorik.domain.model.authority.user.SysUserEntity;
import com.colia.yorik.domain.model.authority.user.UserAccount;
import org.springframework.stereotype.Repository;

/**
 * @Author konglingyao
 * @Date 2020/8/12
 */
@Repository
public class UserRepositoryImpl implements UserRepository {


    @Override
    public SysUserEntity find(UserAccount account) {
        return null;
    }


    @Override
    public void store(SysUserEntity user) {


    }

}
