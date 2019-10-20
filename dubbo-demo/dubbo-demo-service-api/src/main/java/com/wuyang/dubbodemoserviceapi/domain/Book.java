package com.wuyang.dubbodemoserviceapi.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Book implements Serializable {

    /**
     * 书名
     **/
    @NotNull(message = "书名不能为空")
    private String name;

    /**
     * 总页数
     **/
    private Integer pages;

}
