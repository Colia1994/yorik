package com.colia.yorik.yorikdomain.model.authority.user;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import com.colia.yorik.yorikcommon.interfaces.Constants;
import com.colia.yorik.yorikcommon.interfaces.requestBody.CommandValidate;
import lombok.Data;

/**
 * 用户账户
 *
 * @Author konglingyao
 * @Date 2020/8/12
 */
@Data
public class UserAccount implements ValueObject<UserAccount> {

    /**
     * 账户名称
     */
    private String account;

    /**
     * 手机号码 11位 不带区号
     */
    private String phoneNum;

    public UserAccount(String account, String phoneNum) {
        CommandValidate.notEmpty(account, "登录账号不能为空！");
        CommandValidate.matchesPattern(phoneNum, Constants.PHONE_NUM_REGULAR, "手机号码格式错误！");
        this.account = account;
        this.phoneNum = phoneNum;
    }


    @Override
    public boolean sameValueAs(UserAccount other) {
        return other != null && (this.account.equals(other.account) || this.phoneNum.equals(other.phoneNum));
    }
}
