package com.immplah.dtos.validators.annotation;

import com.immplah.dtos.validators.AgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {AgeValidator.class})
public @interface AgeLimit {

    int limit() default 120;

    String message() default "Age  does not match the required adult limit";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
