package com.gx.sharding.jpa.repository;

import com.gx.sharding.jpa.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liyongfei
 */
@Repository
public interface CommunityRepository extends JpaRepository<Community,Long> {
}
