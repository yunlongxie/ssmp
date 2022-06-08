package com.xyl.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyl.BookDao;
import com.xyl.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }


    @Test
    void testSave(){
        Book book = new Book();
        book.setName("aaa");
        book.setType("bbb");
        book.setDescription("ccc");
        bookDao.insert(book);
    }


    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(5);
        book.setName("aaa");
        book.setType("bbb");
        book.setDescription("ccc");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(7);
    }

    @Test
    void testGetAll(){
       bookDao.selectList(null);
    }
    @Test
    void testGetPage(){
        IPage page = new Page(1,5);
        bookDao.selectPage(page,null);
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","Hope");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        String name = "Hope";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name!=null,Book::getName,name);
        bookDao.selectList(lqw);
    }
}
