package com.colia.yorik.dao.mapper;

import com.colia.yorik.dao.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author colia
 * @since 2021-03-10
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findUserByNameAndPwd(@Param("username") String username, @Param("password") String password);


}
