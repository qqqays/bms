package com.qays.bms.dao;

import com.qays.bms.domain.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-10-2018 08:40
 */

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}
