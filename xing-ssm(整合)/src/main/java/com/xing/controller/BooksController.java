package com.xing.controller;

import com.xing.pojo.Books;
import com.xing.service.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BooksController {

    @Autowired
    @Qualifier("booksServiceImpl")
    private BooksServiceImpl booksService;


    //    查所有
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("listBooks", booksService.findAllBooks());
        return "findAll";
    }


    //    跳转到新增页面
    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    //    增加一本书
    @RequestMapping("/addBook")
    public String addBooks(Books books) {
        booksService.addBooks(books);
        return "redirect:/book/findAll";
    }

    //    toUpdateBooks
    @RequestMapping("toUpdateBooks")
    public String toUpdateBooks(@RequestParam("bookID") int bookID,Model model) {
        Books books = booksService.findBooksById(bookID);
        model.addAttribute("books",books);
        return "updateBooks";
    }

    // updateBooks
    @RequestMapping("updateBooks")
    public String updateBooks(Books books) {
        System.out.println("============");
        System.out.println(books);
        System.out.println("============");
        booksService.updateBooks(books);
        return "redirect:/book/findAll";
    }

    // delete
    @RequestMapping("deleteBooksById/{bookID}")
    public String deleteBooksById(@PathVariable int bookID) {
        booksService.delBooksById(bookID);
        return "redirect:/book/findAll";
    }


    // findBooksWith
    @RequestMapping("findBooksWith")
    public String findBooksWith(@RequestParam("flag") String flag,Model model) {
        System.out.println(flag);
        List<Books> books = booksService.findBooksWith(flag);
        System.out.println(books);
        if (books.size()>0){
            model.addAttribute("listBooks",books);
            return "findAll";
        }
        return "redirect:/book/findAll";
    }
}
