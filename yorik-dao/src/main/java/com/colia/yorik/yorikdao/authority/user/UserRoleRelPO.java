package com.colia.yorik.yorikdao.authority.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.colia.yorik.yorikcommon.infrastructure.persistence.po.AbstractPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户角色对应关系表
 * </p>
 *
 * @author colia
 * @since 2020-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_role_rel")
@ApiModel(value = "UserRoleRel对象", description = "用户角色对应关系表")
public class UserRoleRelPO extends AbstractPO {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "是否逻辑删除 默认 0")
    private Boolean isDelete;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
