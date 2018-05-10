package com.qays.bms;

import com.qays.bms.domain.TagEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-10-2018 09:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagTest {

    @Test
    public void tag() {
        TagEntity tag = new TagEntity();
    }
}
