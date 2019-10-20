package com.wuyang.dubbodemoserviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.wuyang.dubbodemoserviceapi.api.BookService;
import com.wuyang.dubbodemoserviceapi.domain.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@ImportResource("classpath:*.xml")
public class DubboDemoServiceConsumerApplication {

	public static void main(String[] args) {
		System.setProperty("dubbo.application.qos.port","33333");
		ApplicationContext context = SpringApplication.run(DubboDemoServiceConsumerApplication.class, args);

		BookService bookService = context.getBean("bookService", BookService.class);

		Integer score = bookService.judgeScore(new Book().setName("jack").setPages(531));


		log.info("书籍分数评为：{}", score);
	}

}
