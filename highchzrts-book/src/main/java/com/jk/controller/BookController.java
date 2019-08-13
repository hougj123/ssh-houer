package com.jk.controller;

import com.jk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
@Autowired
private BookService bookService;

    @RequestMapping("tolist")
  public String toList(){
        return  "list";
    }

@RequestMapping("queryBook")
@ResponseBody
public List<Map<String,Object>> queryBook(){
        List<Map<String,Object>> list= bookService.queryBook();
        List<Map<String,Object>> list1=new ArrayList<>();
    for (Map<String,Object>map1:list) {
        Map<String,Object> map=new HashMap<>();
        map.put("name",map1.get("时间"));
        map.put("y",map1.get("总个数"));
        map.put("sliced","true");
        map.put("selected","true");
        list1.add(map);
    }


return list1;
}
    @RequestMapping("toshow")
    public String toshow(){
        return  "show";
    }
    @RequestMapping("queryBook1")
    @ResponseBody
    public List<Map<String,Object>> queryBook1(){
        List<Map<String,Object>> list= bookService.queryBook1();
        List<Map<String,Object>> list1=new ArrayList<>();
        for (Map<String,Object>map1:list) {
            Map<String,Object> map=new HashMap<>();
            Integer   sj= Integer.parseInt(map1.get("时间").toString());
            if (sj==6){
                map.put("name",sj+"月") ;
                int [] aa =new int[]{200,600,900};
                map.put("data",aa);
            }else if(sj == 7){
                map.put("name",sj+"月") ;
                int [] aa =new int[]{300,200,700};
                map.put("data",aa);
            }else if(sj == 8) {
                map.put("name", sj+"月");
                int[] aa = new int[]{100, 200, 400};
                map.put("data", aa);
            }else {
                map.put("name",sj+"月") ;
                int [] aa =new int[]{150,250,450};
                map.put("data",aa);
            }

            list1.add(map);
        }


        return list1;
    }


}