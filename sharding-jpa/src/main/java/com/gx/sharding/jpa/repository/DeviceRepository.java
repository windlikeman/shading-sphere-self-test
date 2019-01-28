package com.gx.sharding.jpa.repository;

import com.gx.sharding.jpa.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liyongfei
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {
}
