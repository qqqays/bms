package com.qays.bms.dao;

import com.qays.bms.domain.JpaTestEntity;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-07-2018 13:56
 */
@CacheConfig(cacheNames = "users")
public interface JpaTestRepository extends JpaRepository<JpaTestEntity, String>{

    @Cacheable
    List<JpaTestEntity> findAll();
}
