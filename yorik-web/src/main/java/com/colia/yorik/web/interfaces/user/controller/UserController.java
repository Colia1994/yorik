package com.colia.yorik.web.interfaces.user.controller;

import com.colia.yorik.dao.entity.SysUser;
import com.colia.yorik.dao.entity.SysUserAuthorization;
import com.colia.yorik.dao.repository.UserRepository;
import com.colia.yorik.support.application.enums.IdentityTypeEnum;
import com.colia.yorik.support.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.support.interfaces.ajaxresult.AjaxResultUtils;
import com.colia.yorik.support.interfaces.annotation.PermissionLimit;
import com.colia.yorik.web.interfaces.user.facade.UserFacade;
import com.colia.yorik.web.interfaces.user.facade.request.UserRequest;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author konglingyao
 * @Date 2020/8/12
 */
@RestController
@RequestMapping("/api/user")
@Api(tags = "user-controller", description = "用户管理")
@Slf4j
public class UserController {

    @Resource
    private UserFacade userFacade;

    @Resource
    private UserRepository userRepository;

    @GetMapping(value = "/currentUser")
    @PermissionLimit
    public AjaxResponse<Object> currentUser(HttpServletRequest request) {
        return AjaxResultUtils.renderSuccess("登陆成功", userFacade.getCurrentUser(request));
    }

    @PostMapping(value = "/login")
    @PermissionLimit(limit = false)
    public AjaxResponse<Object> login(@RequestBody UserRequest req,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        try {

            return AjaxResultUtils.renderSuccess("登陆成功",
                    userFacade.login(request, response, req.getUserName(), req.getPassword()));
        } catch (Exception ex) {
            log.error("登陆 username={},password={}", req.getUserName(), req.getPassword(), ex);
            return AjaxResultUtils.renderFail(ex.getMessage(), null);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @PermissionLimit(limit = false)
    public AjaxResponse<Object> logout(HttpServletRequest request, HttpServletResponse response) {
        return AjaxResultUtils.renderSuccess(userFacade.logout(request, response));
    }


    @PostMapping("/register")
    @PermissionLimit(limit = false)
    public AjaxResponse<Map<String, Object>> register(@RequestBody UserRequest req) {
        // md5 password
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));

        // check repeat
        SysUser sysUser = userRepository.loadByUserName(req.getUserName());
        if (sysUser != null) {
            return AjaxResultUtils.renderFail("user_username_repeat");
        }

        // write
        sysUser = new SysUser();
        sysUser.setUserName(req.getUserName());
        sysUser.setLevel(0);
        SysUserAuthorization sysUserAuth = new SysUserAuthorization();
        sysUserAuth.setIdentifier(req.getUserName());
        sysUserAuth.setIdentityType(IdentityTypeEnum.ACCOUNT_PASSWORD);
        sysUserAuth.setCredential(req.getPassword());
        userRepository.saveUserInfo(sysUser, sysUserAuth);
        return AjaxResultUtils.renderSuccess();
    }

}
