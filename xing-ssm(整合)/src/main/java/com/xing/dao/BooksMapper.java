package com.xing.dao;

import com.xing.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksMapper {
    // add
    void addBooks(Books books);

    // del
    void delBooksById(@Param("booksId") int id);

    // update
    void updateBooks(Books books);

    // find
    Books findBooksById(@Param("booksId")int id);

    // findAll
    List<Books> findAllBooks();

    // findBooksWith
    List<Books> findBooksWith(String flag);
}
