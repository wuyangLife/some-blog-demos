package cn.zwuyang.validatordemo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.zwuyang.validatordemo.util.BeanValidator;
import cn.zwuyang.validatordemo.vo.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * 邮箱 controller
 * @author wuyang
 **/
@Slf4j
@RestController
@RequestMapping("/email")
public class EmailController {

    /**
     * 添加邮箱条件查询Person
     **/
    @PostMapping("/query")
    public List<Person> queryByAgeAndGender(@Validated(value = {Person.PersonEmailQuery.class}) @RequestBody Person person) {
        // service 查询方法
        log.info("添加邮箱条件: {}  查询Person校验成功", person.getEmail());
        return Collections.emptyList();
    }

    /**
     * 手动校验参数
     **/
    @PostMapping("/create")
    public Long create(@RequestBody Person person) {

        BeanValidator.ValidatorResult result = BeanValidator.validate(person);
        if (result.isHasErrors()) {
            log.warn(JSON.toJSONString(result.getErrorMsg()));
        }

        return 1L;
    }
}
