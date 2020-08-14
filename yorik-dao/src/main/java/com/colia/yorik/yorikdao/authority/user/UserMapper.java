package com.colia.yorik.yorikdao.authority.user;

import com.colia.yorik.yorikcommon.infrastructure.persistence.mapper.SuperMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户持久化接口
 *
 * @Author konglingyao
 * @Date 2020/8/12
 */
public interface UserMapper extends SuperMapper<SysUserPO> {


    SysUserPO selectByUserName(@Param("userName") String userName);



}