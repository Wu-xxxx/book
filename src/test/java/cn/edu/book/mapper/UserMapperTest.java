package cn.edu.book.mapper;

import cn.edu.book.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




/**
 * Created by Wu on 2020/1/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
   @Autowired
    private UserMapper userMapper;
   @Test
    public void ss(){
       User user = userMapper.findByName("admin");
       System.out.println(user.toString());
   }

}