package com.colia.yorik.web.interfaces.basic;

import com.colia.yorik.common.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.common.interfaces.ajaxresult.AjaxResultUtils;
import com.colia.yorik.dao.authority.user.UserMapper;
import com.colia.yorik.support.aop.TestService;
import com.colia.yorik.support.redis.RedisService;
import com.colia.yorik.support.utils.JSONUtil;
import com.colia.yorik.support.utils.JasyptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author konglingyao
 * @Date 2020/7/20
 */
@Controller
@RequestMapping("/api/health")
public class HealthCheckController {

    @Resource
    private JasyptUtils jasyptUtils;

    @Resource
    private TestService testService;

    @Resource
    private RedisService redisService;

    @Autowired(required = false)
    private UserMapper userMapper;


    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public <T> AjaxResponse<T> healthCheck() {
        return AjaxResultUtils.renderSuccess("cl you", null);

    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public <T> AjaxResponse<T> test(String pre, String after) {
        System.out.println(JSONUtil.transferToString(userMapper.selectById("1")));
//        if (StringUtils.isNotBlack(pre)) {
//            // 首先获取配置文件里的原始明文信息
//            String pwd = jasyptUtils.encrypt(pre);
//            // 打印加密前后的结果对比
//            System.out.println("加密结果：" + pwd);
//        }
//        if (StringUtils.isNotBlack(after)) {
//            System.out.println("原始结果：前：" + after);
//            String re = jasyptUtils.decrypt(after);
//            System.out.println("原始结果：" + re);
//        }

        return AjaxResultUtils.renderSuccess("cl you", null);

    }


}
