package com.gx.sharding.jpa.service.impl;

import com.gx.sharding.jpa.ShardingJpaApplicationTests;
import com.gx.sharding.jpa.entity.Room;
import com.gx.sharding.jpa.service.RoomService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class RoomServiceImplTest extends ShardingJpaApplicationTests {

    @Autowired
    private RoomService roomService;

    @Test
    public void saveTest(){
        Room room = new Room();
        room.setBuildingNumber("11栋");
        room.setBuildingFloor("25层");
        room.setCommunityNumber(1002);
        room.setIdUser(265416151L);
        room.setIdCommunity(487454566515L);
        room.setRoomNumber("2504");
        room.setCreateTime(new Date());
        room.setModifyTime(new Date());
        Room roomR = roomService.save(room);


        Assert.assertNotNull(roomR.getIdRoom());
    }
}