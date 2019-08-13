package com.jk.dao;

import com.jk.model.Music;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

public interface MusicDao {

    List<Music> queryMusic(@Param("page") Integer page, @Param("rows") Integer rows, @Param("music") Music music);

    long queryMusicCount(Music music);

    void addMusic(Music music);

    void updateMusic(Music music);

    void deleteMusic(@Param("ids") String ids);
}