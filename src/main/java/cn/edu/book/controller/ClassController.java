package cn.edu.book.controller;

import cn.edu.book.mapper.ClassMapper;
import cn.edu.book.model.Class;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
