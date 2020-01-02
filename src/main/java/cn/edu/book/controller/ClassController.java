package cn.edu.book.controller;

import cn.edu.book.mapper.ClassMapper;
import cn.edu.book.model.Class;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Wu on 2019/12/31.
 */
@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassMapper classMapper;

    @RequestMapping("/listAll")
    public String listAll(){
        List<Class> list = classMapper.getAllClass();
        String str = JSON.toJSONString(list);
        return str;
    }


    @RequestMapping("/query")
    public String getquery(Class class1){
        List<Class> aClass = classMapper.getClass(class1);
        String str = JSON.toJSONString(aClass);
        return str;
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addclass(Class class1){
        if (class1.getClsName()==null||class1.getClsName()==""||class1.getClsNum()==null||class1.getClsNum()==""
        ||class1.getCollegeId()==null){
            System.out.println("未传入成功！");
            String str="未填入班级编号或班级名称或为给班级分配所属学院，请填入完整信息！";
            String s = JSON.toJSONString(str);
            return s;
        }else {
            System.out.println("传入成功!");
            String str="";
            String s = JSON.toJSONString(str);
            classMapper.addClass(class1);
            return s;
        }
    }

    // 删除
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteClass(Integer clsId) {
        classMapper.deleteClassById(clsId);
        String s="删除成功成功!";
        System.out.println(s);
        String str = JSON.toJSONString(s);
        return str;
    }


    // 更新，编辑
    @RequestMapping("/edit")
    @ResponseBody
    public String editClass(Class class1) {
        classMapper.updateClass(class1);
        String s="更新成功!";
        String str = JSON.toJSONString(s);
        return str;
    }
}
