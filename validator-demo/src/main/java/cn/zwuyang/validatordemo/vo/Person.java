package cn.zwuyang.validatordemo.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

import cn.zwuyang.validatordemo.myvalidator.EnumValid;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author wuyang
 **/
@Getter
@Setter
@Accessors(chain = true)
public class Person {

    /**
     * 在进行新增的时候 姓名不能为空
     **/
    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull(message = "电话号码不能为空")
    private String phone;

    /**
     * 只在查询的时候校验
     **/
    @NotNull(message = "年龄不能为空", groups = {PersonAgeGenderQuery.class})
    @Min(value = 1, message = "年龄不能小于1岁", groups = {PersonAgeGenderQuery.class})
    private Integer age;

    /**
     * 只在查询的时候校验(可以为null，不为null时只能取1或2)
     **/
    @Range(min = 1, max = 2, message ="性别只能取1(男)或者2(女)", groups = {PersonAgeGenderQuery.class})
    private Integer gender;

    /**
     * groups 指定该校验仅在 PersonQuery组 中才生效
     **/
    @Email(message = "请输入标准邮箱", groups = {PersonEmailQuery.class})
    private String email;

    @EnumValid(stringValues = {"dog", "cat"}, message = "宠物只养猫和狗")
    private String animal;

    /**
     * 没有实际业务意义 仅用于校验分组
     **/
    public interface PersonEmailQuery {}

    public interface PersonAgeGenderQuery {}
}
