package cn.edu.book.controller;

import cn.edu.book.mapper.BkMapper;
import cn.edu.book.mapper.BkassMapper;
import cn.edu.book.model.Bk;
import cn.edu.book.model.Bkass;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bkteacher")
public class BkteacherController {
    @Autowired
    BkMapper bkMapper;

    @Autowired
    BkassMapper bkassMapper;

    @RequestMapping("/listAll")
    @ResponseBody
    public String listAll(Integer tId){
        List<Bk> list = bkMapper.getBkBytId(tId);
        String str = JSON.toJSONString(list);
        return str;
    }


    @RequestMapping("/check")
    @ResponseBody
    public String check(Integer uId){
        List<Bkass> bkassByuId = bkassMapper.getBkassByuId(uId);
        String str = JSON.toJSONString(bkassByuId);
        return str;
    }


    @RequestMapping("/setstatus")
    @ResponseBody
    public String setstatus(Integer id){
        try {
            bkassMapper.updateBkassStatus(id);
            String s="";
            String str = JSON.toJSONString(s);
            return str;
        }catch (Exception e){
            String s="更改状态失败";
            String str = JSON.toJSONString(s);
            return str;
        }
    }
}

