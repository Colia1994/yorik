package com.colia.yorik.web.interfaces.user.facade.impl;

import com.colia.yorik.dao.entity.SysUser;
import com.colia.yorik.domain.service.authority.user.UserService;
import com.colia.yorik.support.infrastructure.exception.BizProcessException;
import com.colia.yorik.support.utils.CookieUtil;
import com.colia.yorik.support.utils.JSONUtil;
import com.colia.yorik.web.interfaces.user.facade.UserFacade;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

/**
 * @Author konglingyao
 * @Date 2020/8/13
 */
@Service
@Slf4j
public class UserFacadeImpl implements UserFacade {

    public static final String LOGIN_IDENTITY_KEY = "YORIK_LOGIN_IDENTITY";


    @Resource
    private UserService userService;

    @Override
    public Boolean login(HttpServletRequest request, HttpServletResponse response, String username, String password) {

        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        // valid password
        SysUser user = userService.findUserByNameAndPwd(username, passwordMd5);

        if (user == null) {
            throw new BizProcessException("用户名或者密码错误");
        }

        String loginToken = makeToken(user);

        // do login
        CookieUtil.set(response, LOGIN_IDENTITY_KEY, loginToken, false);

        return true;
    }

    private String makeToken(SysUser user) {
        String tokenJson = JSONUtil.transferToString(user);
        return new BigInteger(tokenJson.getBytes()).toString(16);
    }

    private SysUser parseToken(String tokenHex) {
        SysUser xxlJobUser = null;
        if (tokenHex != null) {
            String tokenJson = new String(new BigInteger(tokenHex, 16).toByteArray());      // username_password(md5)
            xxlJobUser = JSONUtil.transferToObj(tokenJson, SysUser.class);
        }
        return xxlJobUser;
    }

    /**
     * logout
     *
     */
    public Boolean logout(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.remove(request, response, LOGIN_IDENTITY_KEY);
        return Boolean.TRUE;
    }

    @Override
    public SysUser getCurrentUser(HttpServletRequest request) {
        String cookieToken = CookieUtil.getValue(request, LOGIN_IDENTITY_KEY);
        if (cookieToken != null) {
            SysUser cookieUser;
            cookieUser = parseToken(cookieToken);
            return cookieUser;
        }
        return null;
    }

    /**
     * logout
     *
     */
    @Override
    public SysUser ifLogin(HttpServletRequest request, HttpServletResponse response) {
        String cookieToken = CookieUtil.getValue(request, LOGIN_IDENTITY_KEY);
        if (cookieToken != null) {
            SysUser cookieUser = null;
            try {
                cookieUser = parseToken(cookieToken);
            } catch (Exception e) {
                logout(request, response);
            }
            if (cookieUser != null) {
                return cookieUser;
            }
        }
        return null;
    }
}
