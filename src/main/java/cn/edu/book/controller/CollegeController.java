package cn.edu.book.controller;

import cn.edu.book.mapper.CollegeMapper;
import cn.edu.book.model.College;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Wu on 2019/12/31.
 */
@Controller
@RequestMapping("/college")
public class CollegeController {
   @Autowired
    private CollegeMapper collegeMapper;

   @RequestMapping("/listAll")
   @ResponseBody
    public String listAll(){
       List<College> list = collegeMapper.getAllCollege();
       String str = JSON.toJSONString(list);
       return str;
   }

   @RequestMapping("/add")
   @ResponseBody
    public String addCollege(College college){
       System.out.println("传入成功");
       String str="传入成功";
       String s = JSON.toJSONString(str);
       collegeMapper.addCollege(college);
       return s;
   }


}
