package cn.edu.book.controller;


import cn.edu.book.mapper.BkMapper;
import cn.edu.book.model.Bk;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bkstudent")
public class BkStudentController {

    @Autowired
    BkMapper bkMapper;

    @RequestMapping("/query")
    @ResponseBody
    public String query(String bkClassName){
        List<Bk> bkBybkClassName = bkMapper.getBkBybkClassName(bkClassName);
        String str= JSON.toJSONString(bkBybkClassName);
        return str;
    }
}
