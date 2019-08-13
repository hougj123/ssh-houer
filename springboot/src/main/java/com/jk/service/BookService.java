package com.jk.service;

import com.jk.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    Map<String, Object> queryBook(Integer page, Integer rows, Book book);

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(String ids);
}
