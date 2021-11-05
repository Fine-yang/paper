package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/")
@Controller
public class IndexController {
//    @ResponseBody
    @GetMapping({"/index", "/", "/index.html"})
    public String index(){
        return "index";
    }
}
