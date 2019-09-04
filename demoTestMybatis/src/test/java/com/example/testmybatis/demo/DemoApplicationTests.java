package com.example.testmybatis.demo;

import com.example.testmybatis.demo.entity.User;
import com.example.testmybatis.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

        User u = userMapper.findById(1l);
        Assert.assertNotNull(u);

    }

}
