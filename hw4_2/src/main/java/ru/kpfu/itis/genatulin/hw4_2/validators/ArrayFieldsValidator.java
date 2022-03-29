package ru.kpfu.itis.genatulin.hw4_2.validators;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import ru.kpfu.itis.genatulin.hw4_2.models.ArrayFields;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayFieldsValidator implements ConstraintValidator<ArrayFields, Object> {

    private String[] fields;

    @Override
    public void initialize(ArrayFields constraintAnnotation) {
        this.fields = constraintAnnotation.fields();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null) {
            return false;
        }
        boolean result = true;
        BeanWrapper entity = new BeanWrapperImpl(o);
        List<String> objectFieldsNames = Arrays.stream(o.getClass().getFields()).map(Field::getName).collect(Collectors.toList());
        for (String field: fields) {
            if (!objectFieldsNames.contains(field)) {
                result = false;
                break;
            }
            else {
                Object fieldValue = entity.getPropertyValue(field);
                if (!(fieldValue instanceof Collection)) {
                    result = false;
                    break;
                }
                else {
                    Collection<?> collection = (Collection<?>) fieldValue;
                    if (collection.size() == 0) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }
}
