package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Music;
import com.jk.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("music")
public class MusicController {
    @Reference
    private MusicService musicService;

    @RequestMapping("toMain")
    public String toMain(){
        return "main";
    }
    @RequestMapping("toShowBook")
    public String toShowBook(){
        return "showBook";
    }

    @RequestMapping("query")
    @ResponseBody
    public Map<String,Object> queryMusic(Integer page, Integer rows, Music  music){
        return musicService.queryMusic(page, rows, music);
    }



    @RequestMapping("addMusic")
    public void addMusic(Music music){
        musicService.addMusic(music);
    }


    @RequestMapping("updateMusic")
    @ResponseBody
    public void updateMusic(Music  music){
        musicService.updateMusic(music);
    }

    @RequestMapping("deleteMusic")
    @ResponseBody
    public void deleteMusic(String ids){
        musicService.deleteMusic(ids);
    }

}