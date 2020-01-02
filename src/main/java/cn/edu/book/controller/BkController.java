package cn.edu.book.controller;


import cn.edu.book.mapper.BkMapper;
import cn.edu.book.model.Bk;
import cn.edu.book.model.Class;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bkadmin")
public class BkController {
    @Autowired
    BkMapper bkMapper;


    @RequestMapping("/listAll")
    @ResponseBody
    public String listAll(){
        List<Bk> list = bkMapper.getAllBk();
        String str = JSON.toJSONString(list);
        return str;
    }

    @RequestMapping("/query")
    @ResponseBody
    public String getquery(Bk bk){
        List<Bk> bk1 = bkMapper.getBk(bk);
        String str = JSON.toJSONString(bk1);
        return str;
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addBk(Bk bk){
        if (bk.getBkName()==null||bk.getBkName()==""||bk.getBkAuthor()==null||bk.getBkAuthor()==""
                ||bk.getTName()==null||bk.getTName()==""||bk.getBkClassName()==null||bk.getBkClassName()==""
        ||bk.getBkNum()==null){
            System.out.println("未传入成功！");
            String str="请填入完整信息！";
            String s = JSON.toJSONString(str);
            return s;
        }else {
            System.out.println("传入成功!");
            String str="";
            String s = JSON.toJSONString(str);
            bkMapper.addBk(bk);
            return s;
        }
    }
}
