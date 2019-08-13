package com.jk.service;

import com.jk.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Map<String, Object>> queryBook() {
        return bookDao.queryBook();
    }

    @Override
    public List<Map<String, Object>> queryBook1() {
        return bookDao.queryBook1() ;
    }
}