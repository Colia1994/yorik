package com.colia.yorik.yorikweb.interfaces.service.impl;

import com.colia.yorik.yorikapplication.application.goods.RecommendGoodsService;
import com.colia.yorik.yoriksupport.redis.RedisService;
import com.colia.yorik.yoriksupport.utils.StringUtils;
import com.colia.yorik.yorikweb.interfaces.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author colia
 * @Date 2019/1/9 21:34
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final static String admin = "%admin";

    @Resource
    private RedisService redisService;


    @Override
    public boolean signUp(String userName, String passWord) {
        try {
            if (StringUtils.isNotBlack(userName) && StringUtils.isNotBlack(passWord)) {
                userName = userName + admin;
                String value = redisService.get(userName);
                if (value != null) {
                    //存在账号 无需注册
                    return false;
                } else {
                    redisService.set(userName, passWord);
                    return true;
                }
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean signIn(String userName, String passWord) {
        try {
            if (StringUtils.isNotBlack(userName) && StringUtils.isNotBlack(passWord)) {
                userName = userName + admin;
                String value = redisService.get(userName);
                return Objects.equals(value, passWord);
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


}
