package com.qays.bms;

import com.qays.bms.dao.ItemRepository;
import com.qays.bms.domain.ItemEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-10-2018 08:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void list() {
        List<ItemEntity> list = itemRepository.findAll(new Sort(Sort.Direction.ASC, "sort"));

        for (ItemEntity ie : list) {
            System.out.println(ie);
        }
    }
}
