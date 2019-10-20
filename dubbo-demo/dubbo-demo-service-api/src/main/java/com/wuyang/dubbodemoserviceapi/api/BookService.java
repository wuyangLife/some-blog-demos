package com.wuyang.dubbodemoserviceapi.api;

import com.wuyang.dubbodemoserviceapi.domain.Book;

public interface BookService {

    /**
     * 获取书籍的评分
     **/
    Integer judgeScore(Book book);
}
