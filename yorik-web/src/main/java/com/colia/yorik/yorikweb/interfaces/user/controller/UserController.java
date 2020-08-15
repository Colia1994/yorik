package com.colia.yorik.yorikweb.interfaces.user.controller;

import com.colia.yorik.yorikcommon.infrastructure.exception.BizProcessException;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.yorikcommon.interfaces.ajaxresult.AjaxResultUtils;
import com.colia.yorik.yorikdomain.model.authority.user.SysUserEntity;
import com.colia.yorik.yorikdomain.service.authority.user.UserService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author konglingyao
 * @Date 2020/8/12
 */
@Controller
@RequestMapping("/api/user")
@Api(tags = "user-controller", description = "用户管理")
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping(value = "login")
    public AjaxResponse<Map<String, Object>> login(@RequestBody SysUserEntity sysUserEntity) {
        String username = sysUserEntity.getName();

        Subject subject = SecurityUtils.getSubject();
        // shiro认证
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, sysUserEntity.getPassword());
        // jwt 集成 shiro认证
        SysUserEntity user = userService.getUserByUserName(username);
        Map<String, Object> map = new HashMap<>();
        if (user == null) {
            System.out.println("用户名不能为空");
            // 抛异常
            throw new BizProcessException("用户名不能为空");
        }
        try {
            // shiro认证认证
            subject.login(usernamePasswordToken);
            map.put("name", user.getName());
        } catch (AuthenticationException e) {
            System.out.println("认证失败" + e.getMessage());
        }
        return AjaxResultUtils.renderSuccess("cl you", map);
    }


    @PostMapping("register")
    public AjaxResponse<Map<String, Object>> register(@RequestBody SysUserEntity sysUserEntity) {

        SysUserEntity userByUserName = userService.getUserByUserName(sysUserEntity.getName());
        if (userByUserName != null) {
            System.out.println("用户名不能为空");
            // 抛异常
        }
        // 加密方式
        String hashAlgorithmName = "MD5";
        String credentials = sysUserEntity.getPassword();

        // 加密次数
        int hashIterations = 2;
        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        // 加密后的密码
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        // 设置加密后的密码
        sysUserEntity.setPassword(simpleHash.toString());
        // 设置盐
        sysUserEntity.setSalt(salt);
        // r入库
        sysUserEntity.store();
        return AjaxResultUtils.renderSuccess("cl you", null);
    }
}
