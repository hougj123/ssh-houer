package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class TestController {
    @RequestMapping("index")
    public String toindex(){
        return "index";
    }
    @RequestMapping("userList")
    public String touserList(){
        return "userList";
    }
    @RequestMapping("roleList")
    public String toroleList(){
        return "roleList";
    }
    @RequestMapping("treeList")
    public String totreeList(){
        return "treeList";
    }

    @RequestMapping("loglist")
    public String tologlist(){
        return "loglist";
    }


}