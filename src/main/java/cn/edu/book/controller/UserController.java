package cn.edu.book.controller;

import cn.edu.book.mapper.UserMapper;
import cn.edu.book.model.User;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Wu on 2020/1/2.
 */
@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
    private UserMapper userMapper;
   @RequestMapping("/listAll")
    public String listAll(){
       List<User> list = userMapper.listAll();
       String str  = JSON.toJSONString(list);
       return str;
   }
    @RequestMapping("/delete")
    public void listAll(Integer id){
        System.out.println("====="+id);
       userMapper.delete(id);
    }
    @RequestMapping("/add")
    public void add(String str){
      User user =JSON.parseObject(str, User.class);
      if (user.getRole().equals("teacher")){
          user.setClassName("/");
      }
      if (user.getRole().equals("admin")){
          user.setClassName("/");
          user.setCollegeName("/");
      }
      userMapper.save(user);
    }
    @RequestMapping("/update")
    public void update(String str){
        User user =JSON.parseObject(str, User.class);
        userMapper.update(user);
    }
    @RequestMapping("/listSelected")
    public String listSelected(String uid,String name,String clsName,String clgName){
        System.out.println(clsName);
        System.out.println(clgName);
       List<User> list = userMapper.listSelected(uid,name,clsName,clgName);
        String str  = JSON.toJSONString(list);
        return str;
    }
}
