package com.colia.yorik.yorikdao.authority.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.colia.yorik.yorikcommon.infrastructure.persistence.po.AbstractPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @Author konglingyao
 * @Date 2020/8/12
 */
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
@Data
@ApiModel(value="SysUser对象", description="用户信息表")
public class SysUserPO extends AbstractPO {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "手机号")
    private String phoneNum;

    @ApiModelProperty(value = "账号状态")
    private Integer state;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "是否逻辑删除 默认 0")
    private Boolean isDelete;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
