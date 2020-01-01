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
import java.util.Map;

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
       if (college.clgName==null||college.clgName==""||college.clgNum==null||college.clgNum==""){
          System.out.println("未传入成功！");
          String str="未填入学院编号或学院名称，请填入完整信息！";
          String s = JSON.toJSONString(str);
          return s;
       }else {
          System.out.println("传入成功!");
          String str="";
          String s = JSON.toJSONString(str);
          collegeMapper.addCollege(college);
          return s;
       }
   }

//   可变条件查询
   @RequestMapping("/query")
   @ResponseBody
   public String getCollege(College college) {
       List<College> college1 = collegeMapper.getCollege(college);
       System.out.println(college1);
       String str=JSON.toJSONString(college1);
       return str;
   }

    // 更新，编辑
    @RequestMapping("/edit")
    @ResponseBody
    public String editCollege(College college) {
        collegeMapper.updateCollege(college);
        String s="更新成功!";
        String str = JSON.toJSONString(s);
        return str;
    }

    // 删除
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteCollege(Integer clgId) {
        collegeMapper.deleteCollegeById(clgId);
        String s="删除成功成功!";
        String str = JSON.toJSONString(s);
        return str;
    }

}
