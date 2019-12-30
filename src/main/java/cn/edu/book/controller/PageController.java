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
}
