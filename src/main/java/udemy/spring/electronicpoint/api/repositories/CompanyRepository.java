package udemy.spring.electronicpoint.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import udemy.spring.electronicpoint.api.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Transactional(readOnly = true)
    Company findByCnpj(String cnpj);

}
