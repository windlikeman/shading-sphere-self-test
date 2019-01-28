package com.gx.sharding.jpa.service.impl;

import com.gx.sharding.jpa.entity.Room;
import com.gx.sharding.jpa.repository.RoomRepository;
import com.gx.sharding.jpa.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }
}
