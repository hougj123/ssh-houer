package com.jk.service;

import com.jk.model.Music;

import java.util.List;
import java.util.Map;

public interface MusicService {


    Map<String, Object> queryMusic(Integer page, Integer rows, Music music);

    void addMusic(Music music);

    void updateMusic(Music music);

    void deleteMusic(String ids);
}