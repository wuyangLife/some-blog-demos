package cn.zwuyang.validatordemo.service;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cn.zwuyang.validatordemo.vo.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * service方法中使用校验需要在类上加 @Validated 注解
 * @author wuyang
 **/
@Slf4j
@Service
@Validated
public class PersonService {

    public Long createPerson(@Valid Person person) {
        // dao层方法
        return 1L;
    }

    public List<Person> queryByAge(@Min(value = 1,message = "年龄最小为1岁") Integer age) {
        log.info("service方法通过校验，年龄:{}", age);
        return Collections.emptyList();
    }
}
