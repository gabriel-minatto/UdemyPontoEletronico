package udemy.spring.electronicpoint.api.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.spring.electronicpoint.api.entities.Company;
import udemy.spring.electronicpoint.api.repositories.CompanyRepository;
import udemy.spring.electronicpoint.api.services.CompanyService;

import java.util.Optional;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Company> findByCnpj(String cnpj) {
        log.info("Buscando uma company para o CNPJ {}", cnpj);
        return Optional.ofNullable(companyRepository.findByCnpj(cnpj));
    }

    @Override
    public Company save(Company company) {
        log.info("Persistindo company: {}", company);
        return this.companyRepository.save(company);
    }
}
