package com.wuyang.dubbodemoserviceprovider.service;

import org.springframework.stereotype.Service;

import com.wuyang.dubbodemoserviceapi.api.BookService;
import com.wuyang.dubbodemoserviceapi.domain.Book;

/**
 * 书籍服务类实现
 * @author wuyang
 **/
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Override
    public Integer judgeScore(Book book) {

        return book.getName().length() + book.getPages();
    }
}
