package com.gx.sharding.jpa.repository;

import com.gx.sharding.jpa.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liyongfei
 */
@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
