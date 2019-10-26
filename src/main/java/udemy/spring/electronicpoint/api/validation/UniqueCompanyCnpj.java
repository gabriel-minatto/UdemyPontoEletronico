package udemy.spring.electronicpoint.api.validation;

import udemy.spring.electronicpoint.api.validation.validators.UniqueCompanyCnpjValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueCompanyCnpjValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface UniqueCompanyCnpj {
    String message() default "This CNPJ is already being used for another company.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
    boolean nullable() default true;
}
