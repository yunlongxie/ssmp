package com.xyl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xyl.domain.Book;
import com.xyl.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    BookService bookService = new BookServiceImpl();
    @Test
    public void testSave() {
        Book book = new Book();
        book.setName("RRR");
        book.setType("GGG");
        book.setDescription("CCC");
        bookService.save(book);
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(9);
        book.setName("TTT");
        book.setType("AAA");
        book.setDescription("CCC");
        bookService.update(book);
    }

    @Test
    public void testDelete() {
        bookService.delete(6);
    }

    @Test
    public void testGetById() {
        bookService.getById(1);
    }

    @Test
    public void testGetAll() {
        bookService.getAll();
    }

    @Test
    public void getPage() {
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println("page.getCurrent() = " + page.getCurrent());
        System.out.println("page.getPages() = " + page.getPages());
        System.out.println("page.getTotal() = " + page.getTotal());
        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getRecords() = " + page.getRecords());
    }
}
