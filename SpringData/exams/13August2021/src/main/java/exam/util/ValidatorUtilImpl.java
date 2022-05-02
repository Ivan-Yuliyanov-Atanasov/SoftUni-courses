package exam.util;


import javax.validation.Validation;
import javax.validation.Validator;

public class ValidatorUtilImpl implements exam.util.ValidatorUtil {

    private final Validator validator;

    public ValidatorUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {

        return validator.validate(entity).isEmpty();
    }



}
