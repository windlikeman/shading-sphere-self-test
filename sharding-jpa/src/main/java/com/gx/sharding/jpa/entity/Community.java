package com.gx.sharding.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * community
 * @author liyongfei 2019-01-28
 */
@Entity
@Table(name = "community")
public class Community implements Serializable {
    /**
     * 
     */
    @Id
    @Column(nullable = false,name = "id_community")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommunity;

    /**
     *
     */
    @Column(name = "community_number")
    private Integer communityNumber;

    /**
     * 小区名字
     */
    @Column(name = "name")
    private String name;

    /**
     * 小区地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;


    /**
     * 
     * @return id_community 
     */
    public Long getIdCommunity() {
        return idCommunity;
    }

    /**
     * 
     * @param idCommunity 
     */
    public void setIdCommunity(Long idCommunity) {
        this.idCommunity = idCommunity;
    }

    /**
     * 小区名字
     * @return name 小区名字
     */
    public String getName() {
        return name;
    }

    /**
     * 小区名字
     * @param name 小区名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 小区地址
     * @return address 小区地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 小区地址
     * @param address 小区地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
     * 修改时间
     * @return modify_time 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    public Integer getCommunityNumber() {
        return communityNumber;
    }

    public void setCommunityNumber(Integer communityNumber) {
        this.communityNumber = communityNumber;
    }

    /**
     * 修改时间
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}