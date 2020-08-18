package com.xing.service;

import com.xing.dao.BooksMapper;
import com.xing.pojo.Books;

import java.util.List;

public class BooksServiceImpl implements BooksService{

    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public void addBooks(Books books) {
        booksMapper.addBooks(books);
    }

    @Override
    public void delBooksById(int id) {
        booksMapper.delBooksById(id);
    }

    @Override
    public void updateBooks(Books books) {
        booksMapper.updateBooks(books);
    }

    @Override
    public Books findBooksById(int id) {
        return booksMapper.findBooksById(id);
    }

    @Override
    public List<Books> findAllBooks() {
        return booksMapper.findAllBooks();
    }

    @Override
    public List<Books> findBooksWith(String flag) {
        return booksMapper.findBooksWith(flag);
    }
}
