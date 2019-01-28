package com.gx.sharding.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * user_community
 * @author liyongfei 2019-01-28
 */
@Entity
@Table(name = "user_community")
public class UserCommunity implements Serializable {
    /**
     * 
     */
    @Id
    @Column(nullable = false,name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 
     */
    @Column(nullable = false,name = "id_user")
    private Long idUser;

    /**
     * 
     */
    @Column(nullable = false,name = "id_community")
    private Long idCommunity;

    /**
     * user_community
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
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
}