package com.xyl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyl.domain.Book;
import com.xyl.service.impl.BookServiceImpl2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author CandyWall
 * @Date 2022/1/20--12:08
 * @Description
 */
@SpringBootTest
public class BookServiceTestCase2 {
    @Autowired
    IBookService bookService = new BookServiceImpl2();
    @Test
    public void testSave() {
        Book book = new Book();
        book.setName("qwdqw");
        book.setType("bbbbbbbbbbbbbbbbbbb");
        book.setDescription("sssssssssssssssss");
        bookService.save(book);
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(8);
        book.setName("wwdwada");
        book.setType("qwdqwdq");
        book.setDescription("qwdqwdqwd");
        bookService.updateById(book);
    }

    @Test
    public void testDelete() {
        bookService.removeById(13);
    }

    @Test
    public void testGetById() {
        bookService.getById(1);
    }

    @Test
    public void testGetAll() {
         bookService.list();
    }

    @Test
    public void getPage() {
        IPage<Book> page = new Page(2, 5);
        bookService.page(page);
        System.out.println("page.getCurrent() = " + page.getCurrent());
        System.out.println("page.getPages() = " + page.getPages());
        System.out.println("page.getTotal() = " + page.getTotal());
        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getRecords() = " + page.getRecords());
    }
}
