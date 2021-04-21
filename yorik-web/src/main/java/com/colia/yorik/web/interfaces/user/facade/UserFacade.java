package com.colia.yorik.web.interfaces.user.facade;

import com.colia.yorik.dao.entity.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author konglingyao
 * @Date 2020/8/13
 */
public interface UserFacade {

    Boolean login(HttpServletRequest request, HttpServletResponse response, String username, String password);

    Boolean logout(HttpServletRequest request, HttpServletResponse response);

    SysUser getCurrentUser(HttpServletRequest request);

    SysUser ifLogin(HttpServletRequest request, HttpServletResponse response);


}
