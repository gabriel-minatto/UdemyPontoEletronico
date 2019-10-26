package udemy.spring.electronicpoint.api.converter;

import org.springframework.stereotype.Component;
import udemy.spring.electronicpoint.api.dtos.LegalPersonRegisterDto;
import udemy.spring.electronicpoint.api.entities.Company;

@Component
public class LegalPersonDTOCompanyConverter implements DTOConverter<Company, LegalPersonRegisterDto> {

    @Override
    public Company toDomain(LegalPersonRegisterDto dto) {
        return Company.builder()
            .cnpj(dto.getCnpj())
            .corporateName(dto.getCorporateName())
            .build();
    }

    @Override
    public LegalPersonRegisterDto toDTO(Company entity) {
        return null;//not aplicable
    }
}
