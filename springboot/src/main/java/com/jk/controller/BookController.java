package com.jk.controller;

import com.jk.model.Book;
import com.jk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

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
    public Map<String,Object> queryBook(Integer page, Integer rows, Book book){
        return bookService.queryBook(page, rows, book);
    }


    @RequestMapping("addBook")
    @ResponseBody
    public void addBook(Book book){

        bookService.addBook(book);
    }


    @RequestMapping("updateBook")
    @ResponseBody
    public void updateBook(Book book){

        bookService.updateBook(book);
    }


    @RequestMapping("deleteBook")
    @ResponseBody
    public void deleteBook(String ids){
        bookService.deleteBook(ids);
    }
}