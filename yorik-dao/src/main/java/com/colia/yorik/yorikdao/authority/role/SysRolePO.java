package com.colia.yorik.yorikdao.authority.role;

import com.baomidou.mybatisplus.annotation.TableName;
import com.colia.yorik.yorikcommon.infrastructure.persistence.po.AbstractPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author colia
 * @since 2020-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
@ApiModel(value = "SysRole对象", description = "用户角色表")
public class SysRolePO extends AbstractPO {

    @ApiModelProperty(value = "父角色id")
    private Long pRoleId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

    @ApiModelProperty(value = "是否逻辑删除 默认 0")
    private Boolean isDelete;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
