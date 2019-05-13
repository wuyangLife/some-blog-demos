package cn.zwuyang.validatordemo.util;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;
import org.springframework.util.CollectionUtils;

/**
 * 手动校验工具
 * @author wuyang
 */
public abstract class BeanValidator {

    // 获取hibernate 的校验实现
    private final static Validator INSTANCE = Validation.byProvider(HibernateValidator.class)
            .configure()
            .failFast(true)
            .buildValidatorFactory()
            .getValidator();

    public static <T> ValidatorResult validate(T t) {
        ValidatorResult tValidatorResult = new ValidatorResult();

        ConstraintViolation contraintViolation = getContraintViolation(t);
        if (null != contraintViolation) {
            tValidatorResult.setHasErrors(true);
            tValidatorResult.setErrorMsg(contraintViolation.getMessage());
        }
        return tValidatorResult;
    }

    private static <T> ConstraintViolation getContraintViolation(T t) {
        Set<ConstraintViolation<T>> constraintViolationSet = INSTANCE
                .validate(t);
        return CollectionUtils.isEmpty(constraintViolationSet) ? null
                : constraintViolationSet.iterator().next();
    }

    /**
     * 校验结果
     */
    public static class ValidatorResult {

        private boolean hasErrors;
        private String errorMsg;

        public boolean isHasErrors() {
            return hasErrors;
        }

        public void setHasErrors(boolean hasErrors) {
            this.hasErrors = hasErrors;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }

}
