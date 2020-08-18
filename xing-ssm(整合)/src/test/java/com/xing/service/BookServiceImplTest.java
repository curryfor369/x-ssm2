package com.xing.service;

import com.xing.pojo.Books;
import org.junit.Test;

public class BookServiceImplTest {


    private BooksServiceImpl booksService = new BooksServiceImpl();

    @Test
    public void test1() {
        for (Books allBook : booksService.findAllBooks()) {
            System.out.println(allBook);
        }
    }
}
