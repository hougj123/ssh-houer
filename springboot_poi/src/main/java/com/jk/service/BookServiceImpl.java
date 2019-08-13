package com.jk.service;

import com.jk.dao.BookDao;
import com.jk.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;


    @Override
    public List<Book> query() {
        return bookDao.query();
    }
}