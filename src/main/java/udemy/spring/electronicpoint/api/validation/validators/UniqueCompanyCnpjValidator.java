package udemy.spring.electronicpoint.api.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import udemy.spring.electronicpoint.api.services.CompanyService;
import udemy.spring.electronicpoint.api.validation.UniqueCompanyCnpj;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueCompanyCnpjValidator implements ConstraintValidator<UniqueCompanyCnpj, String> {

    @Autowired
    private CompanyService service;

    @Override
    public boolean isValid(String cnpj, ConstraintValidatorContext context) {
        return !service.isCnpjAlreadyInUse(cnpj);
    }
}
