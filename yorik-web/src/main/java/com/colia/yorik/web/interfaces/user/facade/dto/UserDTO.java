package com.colia.yorik.web.interfaces.user.facade.dto;


import com.colia.yorik.dao.entity.SysUser;
import lombok.Data;


/**
 * @Author konglingyao
 * @Date 2020/8/13
 */
@Data
public class UserDTO {
    private Long userId;

    private String username;

    private String realName;

    private Boolean isFirstLogin;

    private String token;


    public static UserDTO toDTO(SysUser sysUser){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(sysUser.getId());
        userDTO.setUsername(sysUser.getUserName());
        return userDTO;
    }


}
