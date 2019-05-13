package cn.zwuyang.validatordemo.myvalidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 自定义枚举校验
 * @author wuyang
 **/
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
public @interface EnumValid {

    /**
     * 默认必填 即被校验的值为null，视为失败
     */
    boolean required() default true;

    /**
     * 验证失败的消息
     */
    String message() default "枚举的验证失败";

    /**
     * 分组的内容
     */
    Class<?>[] groups() default {};

    /**
     * 错误验证的级别
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * 可取的 int 值
     */
    int[] intValues() default {};

    /**
     * 可取的 String 值
     */
    String[] stringValues() default {};
}
