package com.colia.yorik.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.colia.yorik.support.application.enums.IdentityTypeEnum;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户授权表
 * </p>
 *
 * @author colia
 * @since 2021-03-10
 */
public class SysUserAuthorization implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private Long userId;

    /**
     * 登陆类型 1手机 密码 2手机 验证码 2邮箱 3微信
     */
    private IdentityTypeEnum identityType;


    /**
     * 账号标识（手机号 邮箱 用户名或第三方应用的唯一标识 ）
     */
    private String identifier;

    /**
     * 密码凭证（站内的保存密码，站外的不保存或保存token）
     */
    private String credential;

    /**
     * 是否逻辑删除 默认 0
     */
    private Boolean isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public IdentityTypeEnum getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityTypeEnum identityType) {
        this.identityType = identityType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SysUserAuthorization{" +
        "id=" + id +
        ", userId=" + userId +
        ", identityType=" + identityType +
        ", identifier=" + identifier +
        ", credential=" + credential +
        ", isDelete=" + isDelete +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
