package com.jk.cotroller;

import com.jk.model.Book;
import com.jk.service.BookService;
import com.jk.util.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

@RequestMapping("toshow")
   private String toshow(){
    return "show";
}
    @RequestMapping("queryBook")
    @ResponseBody
    public List<Book> query(){
        List<Book> list =  bookService.query();
        return  list;
    }


    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletResponse response){
    String  title = "1902B书籍管理";
    String[] rowName={"编号","书名","时间","价格","作者"};
    List<Object[]>  dataList = new ArrayList<Object[]>();
    List<Book> list =  bookService.query();
        for(Book book:list){
            Object[] obj =new Object[rowName.length];
            obj[0]=book.getId();
            obj[1]=book.getName();
            obj[2]=book.getBdate();
            obj[3]=book.getPrice();
            obj[4]=book.getAuthor();

            dataList.add(obj);
        }
        ExportExcel exportExcel =new ExportExcel(title,rowName,dataList,response);
        try {
            exportExcel.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}