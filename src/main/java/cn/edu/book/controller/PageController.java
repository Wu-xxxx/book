package cn.edu.book.controller;

import cn.edu.book.mapper.ClassMapper;
import cn.edu.book.mapper.CollegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Wu on 2019/12/30.
 */
@Controller
public class PageController {
    @Autowired
    CollegeMapper collegeMapper;

    @Autowired
    ClassMapper classMapper;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error){
        if (error != null) {
            model.addAttribute("error", "用户名或密码错误");
        }

        System.out.println(collegeMapper.getAllCollege());
        System.out.println(classMapper.getAllClass());
        return "login";
    }
    @RequestMapping("/college")
    public String college(){
        return "college";
    }
    @RequestMapping("/class")
    public String classmgmt(){
        return "class";
    }
    @RequestMapping("/bookadmin")
    public String bookadmin(){
        return "bookadmin";
    }
    @RequestMapping("/course")
    public String course(){
        return "course";
    }
    @RequestMapping("/user")
    public String user(){
        return "usermgmt";
    }


}
