package com.gx.sharding.jpa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * room
 * @author liyongfei 2019-01-28
 */
@Entity
@Table(name = "room")
public class Room {
    /**
     * 
     */
    @Id
    @Column(nullable = false,name = "id_room")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoom;

    /**
     * 
     */
    @Column(name = "id_community")
    private Long idCommunity;

    /**
     * 社区编号，用于分表
     */
    @Column(name = "community_number")
    private Integer communityNumber;

    /**
     * 
     */
    @Column(name = "id_user")
    private Long idUser;

    /**
     * 
     */
    @Column(name = "building_number")
    private String buildingNumber;

    /**
     * 
     */
    @Column(name = "building_floor")
    private String buildingFloor;

    /**
     * 
     */
    @Column(name = "room_number")
    private String roomNumber;

    /**
     * 
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 
     * @return id_room 
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
     * 社区编号，用于分表
     * @return community_number 社区编号，用于分表
     */
    public Integer getCommunityNumber() {
        return communityNumber;
    }

    /**
     * 社区编号，用于分表
     * @param communityNumber 社区编号，用于分表
     */
    public void setCommunityNumber(Integer communityNumber) {
        this.communityNumber = communityNumber;
    }

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
     * 
     * @return building_number 
     */
    public String getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * 
     * @param buildingNumber 
     */
    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber == null ? null : buildingNumber.trim();
    }

    /**
     * 
     * @return building_floor 
     */
    public String getBuildingFloor() {
        return buildingFloor;
    }

    /**
     * 
     * @param buildingFloor 
     */
    public void setBuildingFloor(String buildingFloor) {
        this.buildingFloor = buildingFloor == null ? null : buildingFloor.trim();
    }

    /**
     * 
     * @return room_number 
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * 
     * @param roomNumber 
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
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
     * @return modify_time 
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * @param modifyTime 
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}