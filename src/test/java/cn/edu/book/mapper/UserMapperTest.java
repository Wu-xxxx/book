package cn.edu.book.mapper;

import cn.edu.book.model.Bk;
import cn.edu.book.model.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Wu on 2020/1/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
   @Autowired
    private UserMapper userMapper;
   @Autowired
   private BkMapper bkMapper;

   @Test
    public void ss(){
       User user = userMapper.findByName("admin");
       System.out.println(user.toString());
   }
    @Test
    public void zzz(){
        List<Bk> list = bkMapper.getAllBk();
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> mapNow = new HashMap<>();
        List<String> bookName = new ArrayList<>();
        List<Integer> allNum = new ArrayList<>();
        List<Integer> nowNum = new ArrayList<>();
        for (int i = 0;i<list.size();i++){
            if (!map.containsKey(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor())){
                map.put(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor(), list.get(i).getBkNum());
            }else{
                int value = map.get(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor());
                map.put(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor(),value+list.get(i).getBkNum());
            }
            if (!mapNow.containsKey(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor())){
                mapNow.put(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor(), list.get(i).getBkNumNow());
            }else{
                int value = mapNow.get(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor());
                mapNow.put(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor(),value+list.get(i).getBkNumNow());
            }
        }
        for (Map.Entry<String, Integer> map1:map.entrySet()){
//            System.out.println(map1.getValue());
//            System.out.println(map1.getKey());
        }
        for (Map.Entry<String, Integer> map1:mapNow.entrySet()){
            bookName.add(map1.getKey());
            allNum.add(map.get(map1.getKey()));
            nowNum.add(map1.getValue());
        }
        String bkName  = JSON.toJSONString(bookName);
        String allNumBk  = JSON.toJSONString(allNum);
        String nowNumBk  = JSON.toJSONString(nowNum);
        //return bkName+"|"+allNumBk+"|"+nowNumBk;
    }
}