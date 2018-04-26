package com.qays.bms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qays.bms.domain.JpaTestEntity;
import com.qays.bms.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-26-2018 10:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MybatisTest {

    @Autowired
    TestMapper tm;

    @Test
    @Rollback
    public void fuck() {
        System.out.println("------------------------------");
//        System.out.println(tm.one().getId() + tm.one().getContents());
        System.out.println("------------------------------");
    }

    @Test
    public void aa() {
        for (JpaTestEntity jte : tm.all()) {
            System.out.println();
//            System.out.println(jte.getId() + jte.getContents());
            System.out.println();
        }
    }

    @Test
    public void page() {
        PageHelper.startPage(1, 3);

        PageInfo<JpaTestEntity> page = new PageInfo<>(tm.page());

        System.out.println(page);
    }

}
