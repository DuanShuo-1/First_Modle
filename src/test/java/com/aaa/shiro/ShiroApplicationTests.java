package com.aaa.shiro;

import com.aaa.entity.User;
import com.aaa.entity.Xiaoliang;
import com.aaa.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.List;

import static org.xmlunit.diff.ElementSelectors.byName;

@SpringBootTest
class ShiroApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
       int a = 1;

       int c = ++a;
        int b = a++;
       System.out.println(c);
       System.out.println(b);
       System.out.println(++a);
       System.out.println(a++);
       System.out.println(a);
        

    }


}
