package com.gx.sharding.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author liyongfei 2019-01-28
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    /**
     * 
     */
    @Id
    @Column(nullable = false,name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "community_number")
    private Integer communityNumber;
    /**
     * 电话
     */
    @Column(name = "phone_number")
    private Long phoneNumber;

    /**
     * 
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 0，可用 1不可用
     */
    @Column(name = "status")
    private String status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * user
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id_user 
     */
    public Long getIdUser() {
        return idUser;
    }

    /**
     * 
     * @param idUser 
     */
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    /**
     * 电话
     * @return phone_number 电话
     */
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 电话
     * @param phoneNumber 电话
     */
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 用户密码
     * @return password 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 0，可用 1不可用
     * @return status 0，可用 1不可用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 0，可用 1不可用
     * @param status 0，可用 1不可用
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public Integer getCommunityNumber() {
        return communityNumber;
    }

    public void setCommunityNumber(Integer communityNumber) {
        this.communityNumber = communityNumber;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}