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


    @RequestMapping("/tupdate")
    public String tupdate(User user){
       try {
           userMapper.tupdate(user);
           String s="";
           String str = JSON.toJSONString(s);
           return str;
       }catch (Exception e){
           String s="更新失败";
           String str = JSON.toJSONString(s);
           return  str;
       }
    }

    @RequestMapping("/listSelected")
    public String listSelected(User user){
       List<User> list = userMapper.listSelected(user);
        String str  = JSON.toJSONString(list);
        return str;
    }
    @RequestMapping("/findbyUid")
    public String findbyUid(Integer uId){
        User byUid = userMapper.findByUid(uId);
        String str  = JSON.toJSONString(byUid);
        return str;
    }


}
