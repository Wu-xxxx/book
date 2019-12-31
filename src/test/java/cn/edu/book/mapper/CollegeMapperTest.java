package cn.edu.book.mapper;

import cn.edu.book.model.Class;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * Created by Wu on 2019/12/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollegeMapperTest {
   @Autowired
    private ClassMapper classMapper;
   @Test
    public void ss(){
       List<Class> list = classMapper.getAllClass();
       String str = JSON.toJSONString(list);
       System.out.println(str);
   }
}