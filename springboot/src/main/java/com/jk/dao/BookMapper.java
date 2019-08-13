package com.jk.dao;

import com.jk.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    List<Book> queryBook(@Param("page") Integer page, @Param("rows") Integer rows, @Param("book") Book book);

    long queryBookCount(Book book);


    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(@Param("ids")String ids);
}
