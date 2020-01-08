package cn.edu.book.controller;


import cn.edu.book.mapper.BkMapper;
import cn.edu.book.model.Bk;
import cn.edu.book.model.Class;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        try {
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

        }catch (Exception e){
            String str="请核对输入的教师工号id是否正确！";
            String s = JSON.toJSONString(str);
            return s;
        }

    }




    // 更新，编辑
    @RequestMapping("/edit")
    @ResponseBody
    public String editCourse(Bk bk) {
        try {
            bkMapper.updateBk(bk);
            String s="";
            String str = JSON.toJSONString(s);
            return str;
        }catch (Exception e){
            String s="请核对输入的教师工号id是否正确！";
            String str = JSON.toJSONString(s);
            return str;
        }
    }



    // 删除
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteCourse(Integer bkId) {
        bkMapper.deleteBkById(bkId);
        String s="删除成功!";
        System.out.println(s);
        String str = JSON.toJSONString(s);
        return str;
    }
    @RequestMapping("/listkucun")
    @ResponseBody
    public String listkucun(){
        List<Bk> list = bkMapper.getAllBk2();
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> mapNow = new HashMap<>();
        List<String> bookName = new ArrayList<>();
        List<Integer> allNum = new ArrayList<>();
        List<Integer> nowNum = new ArrayList<>();
        for (int i = 0;i<list.size();i++){
            if (!map.containsKey(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor())){
                map.put(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor(), list.get(i).getBkNum());
            }else{
                int value = map.get(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor());
                map.put(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor(),value+list.get(i).getBkNum());
            }
            if (!mapNow.containsKey(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor())){
                mapNow.put(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor(), list.get(i).getBkNumNow());
            }else{
                int value = mapNow.get(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor());
                mapNow.put(list.get(i).getBkName()+"-"+list.get(i).getBkAuthor(),value+list.get(i).getBkNumNow());
            }
        }
        for (Map.Entry<String, Integer> map1:map.entrySet()){
//            System.out.println(map1.getValue());
//            System.out.println(map1.getKey());
        }
        for (Map.Entry<String, Integer> map1:mapNow.entrySet()){
            bookName.add(map1.getKey());
            allNum.add(map.get(map1.getKey()));
            nowNum.add(map1.getValue());
        }
        String bkName  = JSON.toJSONString(bookName);
        String allNumBk  = JSON.toJSONString(allNum);
        String nowNumBk  = JSON.toJSONString(nowNum);
        return bkName+"|"+allNumBk+"|"+nowNumBk;
    }


}
