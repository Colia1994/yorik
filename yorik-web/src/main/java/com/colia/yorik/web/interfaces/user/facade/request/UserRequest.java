package com.colia.yorik.web.interfaces.user.facade.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author konglingyao
 * @Date 2020/8/12
 */
@Data
@ApiModel(description = "用户信息")
public class UserRequest {

    private String userName;

    private String phoneNum;

    private String password;

    private String newPwd;

    private String oldPwd;

    private String confirmPwd;

    private Long userId;


}
