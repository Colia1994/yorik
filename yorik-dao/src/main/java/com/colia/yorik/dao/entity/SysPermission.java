package com.colia.yorik.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户权限表
 * </p>
 *
 * @author colia
 * @since 2021-03-10
 */
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父权限id
     */
    private Long pPermissionId;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限描述
     */
    private String permissionDesc;

    /**
     * 是否逻辑删除 默认 0
     */
    private Boolean isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpPermissionId() {
        return pPermissionId;
    }

    public void setpPermissionId(Long pPermissionId) {
        this.pPermissionId = pPermissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
        "id=" + id +
        ", pPermissionId=" + pPermissionId +
        ", permissionName=" + permissionName +
        ", permissionDesc=" + permissionDesc +
        ", isDelete=" + isDelete +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
