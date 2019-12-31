package cn.edu.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Wu on 2019/12/30.
 */
@Controller
public class PageController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
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
