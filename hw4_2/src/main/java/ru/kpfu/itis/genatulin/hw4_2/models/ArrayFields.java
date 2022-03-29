package ru.kpfu.itis.genatulin.hw4_2.models;

import ru.kpfu.itis.genatulin.hw4_2.validators.ArrayFieldsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ArrayFieldsValidator.class)
public @interface ArrayFields {
    String message() default "One of the fields either doesn't exist, is not a collection or doesn't contain any elements";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String[] fields() default {};
}
