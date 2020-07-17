package com.colia.yorik.yorikweb.interfaces.controller;

import com.colia.yorik.yorikweb.domain.User;
import com.colia.yorik.yorikweb.interfaces.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆相关控制器
 *
 * @author colia
 * @date 2019/1/9 21:24
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, User user) {
        Map<String, Object> map = new HashMap<>();
        String userName = user.getUserName();
        String password = user.getPassword();
        if (loginService.signIn(userName, password)) {
            request.getSession().setAttribute("user", user);
            map.put("result", 1);
        } else {
            map.put("result", 0);
        }
        return map;
    }


    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> signUp(User user) {
        Map<String, Object> map = new HashMap<>();
        String userName = user.getUserName();
        String password = user.getPassword();
        if (loginService.signUp(userName, password)) {
            map.put("success", true);
        } else {
            map.put("result", false);
        }
        return map;
    }
}
