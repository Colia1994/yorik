package com.colia.yorik.dao.authority.user;

import com.colia.yorik.common.infrastructure.persistence.mapper.SuperMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户持久化接口
 *
 * @Author konglingyao
 * @Date 2020/8/12
 */
public interface UserMapper extends SuperMapper<SysUserPO> {


    /**
     * 根据用户名查询完整用户信息
     */
    SysUserPO selectByUserName(@Param("userName") String userName);


}