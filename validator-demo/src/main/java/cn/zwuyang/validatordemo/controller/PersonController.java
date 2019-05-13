package cn.zwuyang.validatordemo.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zwuyang.validatordemo.vo.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * Person Controller
 * @author wuyang
 **/
@Slf4j
@RestController
@RequestMapping("/person")
@Validated
public class PersonController {

    /**
     * 新增person 要求名字不能为空
     * 没有指定校验组 则对 Person中 未指定分组的属性进行校验
     **/
    @PostMapping("/create")
    public Long createPerson(@Valid @RequestBody Person person) {
        // service 方法
        log.info("新增person-姓名不能为空{}校验通过", person.getName());
        return 1L;
    }

    /**
     * 按照年龄和性别查询person 需要校验年龄和性别
     **/
    @PostMapping("/query")
    public List<Person> queryByAgeAndGender(@Validated({Person.PersonAgeGenderQuery.class}) @RequestBody Person person) {
        // service 查询方法
        log.info("按照年龄和性别批量查询-年龄:{},性别:{}校验成功", person.getAge(), person.getGender());
        return Collections.emptyList();
    }

    /**
     * 不需要实体，直接对参数进行校验 需要在类上添加 @Validated 注解
     **/
    @GetMapping("/queryByPhone/{phone}")
    public Person queryByPhone(@Length(min = 11, max = 11, message = "请输入11位电话号码")
                               @PathVariable String phone) {
        // service 查询方法
        log.info("根据电话号码:{} 查询person-校验成功", phone);
        return new Person();
    }

}
