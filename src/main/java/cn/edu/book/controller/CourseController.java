package cn.edu.book.controller;


import cn.edu.book.mapper.CourseMapper;
import cn.edu.book.model.Class;
import cn.edu.book.model.College;
import cn.edu.book.model.Course;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

   @Autowired
   CourseMapper courseMapper;

    @RequestMapping("/listAll")
    @ResponseBody
    public String listAll(){
        List<Course> allCourse = courseMapper.getAllCourse();
        String str = JSON.toJSONString(allCourse);
        return str;
    }


    @RequestMapping("/query")
    @ResponseBody
    public String getquery(Course course){
        List<Course> course1 = courseMapper.getCourse(course);
        String str = JSON.toJSONString(course1);
        return str;
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addcourse(Course course){
        if (course.getCourseName()==null||course.getCourseName()==""||course.getCourseNum()==null||course.getCourseNum()==""
                ||course.getClassId()==null){
            System.out.println("未传入成功！");
            String str="未填入课程编号或课程名称或为给课程分配所属班级，请填入完整信息！";
            String s = JSON.toJSONString(str);
            return s;
        }else {
            System.out.println("传入成功!");
            String str="";
            String s = JSON.toJSONString(str);
            courseMapper.addCourse(course);
            return s;
        }
    }


    // 更新，编辑
    @RequestMapping("/edit")
    @ResponseBody
    public String editCourse(Course course) {
        courseMapper.updateCourse(course);
        String s="更新成功!";
        String str = JSON.toJSONString(s);
        return str;
    }


    // 删除
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteCourse(Integer courseId) {
        courseMapper.deleteCourseById(courseId);
        String s="删除成功!";
        System.out.println(s);
        String str = JSON.toJSONString(s);
        return str;
    }


}
