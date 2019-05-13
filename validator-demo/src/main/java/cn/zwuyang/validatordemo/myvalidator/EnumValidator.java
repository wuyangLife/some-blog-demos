package cn.zwuyang.validatordemo.myvalidator;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 枚举校验实现类
 * @author wuyang
 **/
public class EnumValidator implements ConstraintValidator<EnumValid,Object> {

    private EnumValid enumValid;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        // 注解表明为必选项 则不允许为空，否则可以为空
        if (value == null) {
            return this.enumValid.required() ? false : true;
        }
        //最终的返回结果
        Boolean result = Boolean.FALSE;
        // 获取 参数的数据类型
        Class<?> valueClass = value.getClass();

        return judgeValue(value);

    }


    @Override
    public void initialize(EnumValid enumValid) {
        this.enumValid = enumValid;
    }

    private boolean judgeValue(Object value) {

        if (value instanceof Integer || value instanceof Long) {
            int[] validValues = this.enumValid.intValues();
            for (int intValue : validValues) {
                if(intValue == (int)value) {
                    return true;
                }
            }
            return false;

        } else if (value instanceof String){
            String[] strValues = this.enumValid.stringValues();
            for (String intValue : strValues) {
                if(Objects.equals(intValue, (String)value)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
