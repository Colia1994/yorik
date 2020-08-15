package com.colia.yorik.yorikdomain.model.authority.user;

import com.colia.yorik.yorikcommon.domain.entity.Entity;
import com.colia.yorik.yorikcommon.domain.entity.EntitySupport;
import com.colia.yorik.yorikcommon.domain.entity.Identity;
import com.colia.yorik.yorikdomain.repository.UserRepository;
import com.colia.yorik.yoriksupport.utils.ApplicationContextUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author konglingyao
 * @Date 2020/8/12
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class SysUserEntity extends EntitySupport<SysUserEntity, UserAccount> implements Entity<SysUserEntity, UserAccount> {

    /**
     * 登录账号
     */
    @Identity
    private UserAccount account;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 存储用户
     */
    public void store() {
        UserRepository userRepository =
                (UserRepository) ApplicationContextUtils.getBean(UserRepository.class);

        userRepository.store(this);
        //UserService userService = (UserService) ApplicationContextUtils.getBean(UserService.class);
//        if(!this.isEnabled()){//如果用户被禁用，将其从相应用户组移除
//            userRepository.disableUserGroup(this.account);
//        }else{//如果用户被启用，启用其关联的用户组
//            userRepository.updateUserGroup(this.getAccount(),null, UserGroupStatus.ENABLE);
//        }
    }


}
