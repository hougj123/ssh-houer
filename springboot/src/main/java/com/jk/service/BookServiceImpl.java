package com.jk.service;

import com.jk.dao.BookMapper;
import com.jk.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;


    @Override
    public Map<String, Object> queryBook(Integer page, Integer rows, Book book) {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("rows",bookMapper.queryBook((page-1)*rows, rows, book));
        map.put("total",bookMapper.queryBookCount(book));
        return map;
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBook(String ids) {
        bookMapper.deleteBook(ids);
    }

}