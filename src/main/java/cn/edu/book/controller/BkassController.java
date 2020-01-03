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
@RequestMapping("/bkass")
public class BkassController {

    @Autowired
    BkassMapper bkassMapper;

    @Autowired
    BkMapper bkMapper;

    @RequestMapping("/dst")
    @ResponseBody
    public String distribute(Bkass bkass){
        try {
            String s="";
            bkassMapper.addBkass(bkass);
            List<Bk> bkById = bkMapper.getBkById(bkass.getBkId());
            Integer BkNumNow=bkById.get(0).getBkNumNow();
            System.out.println(BkNumNow);
            BkNumNow=BkNumNow-1;
            bkById.get(0).setBkNumNow(BkNumNow);
            bkMapper.updateBk(bkById.get(0));
            if(BkNumNow>0){
                String str = JSON.toJSONString(s);
                return str;
            }else {
                s="库存数量不足分发";
                String str = JSON.toJSONString(s);
                return str;
            }
        } catch (Exception e){
            String s="请核对输入的教师工号/学号是否正确！";
            String str = JSON.toJSONString(s);
            return str;
        }
    }



    @RequestMapping("/listAll")
    @ResponseBody
    public String listAll(){
        List<Bkass> allBkass = bkassMapper.getAllBkass();
        String str = JSON.toJSONString(allBkass);
        return str;
    }



    @RequestMapping("/query")
    @ResponseBody
    public String getquery(Bkass bkass){
        List<Bkass> bkass1 = bkassMapper.getBkass(bkass);
        String str = JSON.toJSONString(bkass1);
        return str;
    }

}
