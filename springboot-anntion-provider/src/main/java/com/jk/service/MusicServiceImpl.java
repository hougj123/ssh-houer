package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.MusicDao;
import com.jk.model.Music;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicDao musicDao;



    @Override
    public Map<String, Object> queryMusic(Integer page, Integer rows, Music music) {
        return null;
    }

    @Override
    public void addMusic(Music music) {

    }

    @Override
    public void updateMusic(Music music) {

    }

    @Override
    public void deleteMusic(String ids) {

    }
}