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
    @RequestMapping("/usermgmt")
    public String user(){
        return "usermgmt";
    }
    @RequestMapping("/bookteacher")
    public String bookteacher(){
        return "bookteacher";
    }
    @RequestMapping("/bookstudent")
    public String bookstudent(){
        return "bookstudent";
    }
    @RequestMapping("/tuser")
    public String tuser(){
        return "tuser";
    }
    @RequestMapping("/suser")
    public String suser(){
        return "suser";
    }
}
