package com.jk.service;

import com.jk.dao.MusicDao;
import com.jk.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "musicService")
public class MusicServiceImpl implements MusicService {
@Autowired
private MusicDao musicDao;


    @Override
    public Map<String, Object> queryMusic(Integer page, Integer rows, Music music) {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("rows",musicDao.queryMusic((page-1)*rows, rows, music));
        map.put("total",musicDao.queryMusicCount(music));
        return map;
    }

    @Override
    public void addMusic(Music music) {
        musicDao.addMusic(music);
    }

    @Override
    public void updateMusic(Music music) {
        musicDao.updateMusic(music);
    }

    @Override
    public void deleteMusic(String ids) {
        musicDao.deleteMusic(ids);
    }
}