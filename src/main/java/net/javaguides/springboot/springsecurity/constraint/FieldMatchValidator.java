package net.javaguides.springboot.springsecurity.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName=constraintAnnotation.first();
        secondFieldName=constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value,
         final ConstraintValidatorContext context) {
        boolean valid = true;
        try {
            final Object firstObj = 
                    BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj =
                    BeanUtils.getProperty(value, secondFieldName);            
            System.out.println("firstObj: "+firstObj);
            System.out.println("secondObj: "+secondObj);
            valid =  (firstObj == null && secondObj == null)
                || (firstObj != null && firstObj.equals(secondObj));
        } catch (final Exception e) {
           
        }
        if(!valid){            
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(secondFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation();
        }
        return valid;
    }
    
}