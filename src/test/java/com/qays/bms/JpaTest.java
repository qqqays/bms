package com.qays.bms;

import com.qays.bms.domain.JpaTestEntity;
import com.qays.bms.repository.JpaTestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-26-2018 14:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {
    @Autowired
    JpaTestRepository jr;

    @Test
    public void jpa() {
        for (JpaTestEntity je : jr.findAll()) {
            System.out.println(je.getContents());
        }
    }

    @Test
    public void cache() {
        jr.findAll();
        jr.findAll();
        jr.findAll();
        System.out.println(jr.findAll());
    }
}
