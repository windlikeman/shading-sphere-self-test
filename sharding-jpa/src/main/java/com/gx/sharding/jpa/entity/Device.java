package com.gx.sharding.jpa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * device
 * @author liyongfei 2019-01-28
 */
@Entity
@Table(name = "device")
public class Device {
    /**
     * 
     */
    @Id
    @Column(nullable = false,name = "id_device")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDevice;

    /**
     * 
     */
    @Column(name = "id_room")
    private Long idRoom;

    /**
     * 
     */
    @Column(name = "community_number")
    private Long communityNumber;

    /**
     * 
     */
    @Column(name = "device_name")
    private String deviceName;

    /**
     * 
     */
    @Column(name = "device_number")
    private String deviceNumber;

    /**
     * 
     */
    @Column(name = "devicecol")
    private String devicecol;

    /**
     * 
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 
     * @return id_device 
     */
    public Long getIdDevice() {
        return idDevice;
    }

    /**
     * 
     * @param idDevice 
     */
    public void setIdDevice(Long idDevice) {
        this.idDevice = idDevice;
    }

    /**
     * 
     * @return id_room 
     */
    public Long getIdRoom() {
        return idRoom;
    }

    /**
     * 
     * @param idRoom
     */
    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    /**
     * 
     * @return community_number 
     */
    public Long getCommunityNumber() {
        return communityNumber;
    }

    /**
     * 
     * @param communityNumber 
     */
    public void setCommunityNumber(Long communityNumber) {
        this.communityNumber = communityNumber;
    }

    /**
     * 
     * @return device_name 
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * 
     * @param deviceName 
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    /**
     * 
     * @return device_number 
     */
    public String getDeviceNumber() {
        return deviceNumber;
    }

    /**
     * 
     * @param deviceNumber 
     */
    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber == null ? null : deviceNumber.trim();
    }

    /**
     * 
     * @return devicecol 
     */
    public String getDevicecol() {
        return devicecol;
    }

    /**
     * 
     * @param devicecol 
     */
    public void setDevicecol(String devicecol) {
        this.devicecol = devicecol == null ? null : devicecol.trim();
    }

    /**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return update_time 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}