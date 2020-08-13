package com.colia.yorik.yorikdomain.repository;


import com.colia.yorik.yorikdao.authority.user.UserMapper;
import com.colia.yorik.yorikdao.authority.user.UserPO;
import com.colia.yorik.yorikdomain.model.authority.user.SysUserEntity;
import com.colia.yorik.yorikdomain.model.authority.user.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author konglingyao
 * @Date 2020/8/12
 */
@Repository
public class UserRepositoryImpl implements UserRepository {


    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public SysUserEntity find(UserAccount account) {
//        return transferUser(findUserPO(account));
        return null;
    }


    @Override
    public void store(SysUserEntity user) {

        UserPO userPO = findUserPO(user.getAccount());

//        if (userPO == null) {
//            userMapper.insert(transferUserPO(user));
//        } else {
//            BeanUtils.copyProperties(transferUserPO(user), userPO, "id");
//            userMapper.updateById(userPO);
//        }
    }

    private UserPO findUserPO(UserAccount account) {
        UserPO userPO = userMapper.selectByUserName(account.getAccount());
        return userPO;
    }

//    private SysUserEntity transferUser(UserPO userPO) {
//        if(null != userPO){
//            UserAccount userAccount = new UserAccount(userPO.getUserName());
//            BankCode bankCode = new BankCode(userPO.getBankCode());
//            OrganizationCode organizationCode = new OrganizationCode(userPO.getOrg());
//            UserHandling userHandling = new UserHandling(userPO.getCreateTime(),userPO.getUpdateTime(),UserStatus.parse(userPO.getStatus()));
//            return new SysUserEntity(userAccount,userPO.getRealName(),bankCode,organizationCode,userHandling,userPO.getIsAdmin()==null?0:Integer.valueOf(userPO.getIsAdmin()));
//        }
//
//        return null;
//    }
//
//    private UserPO transferUserPO(SysUserEntity user) {
//        UserPO userPO = new UserPO();
//        userPO.setId(IdWorker.getId());
//        userPO.setUserName(user.getAccount().getAccount());
//        userPO.setRealName(user.getName());
//        userPO.setStatus(user.getUserHandling().getUserStatus().getCode());
//        userPO.setCreateTime(user.getUserHandling().getInsertTime());
//        userPO.setUpdateTime(user.getUserHandling().getUpdateTime());
//        userPO.setOrg(user.getOrganizationCode().getCode());
//        userPO.setBankCode(user.getOrganizationCode().getCode());
//        return userPO;
//    }
}
