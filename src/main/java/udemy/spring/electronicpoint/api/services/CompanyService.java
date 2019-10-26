package udemy.spring.electronicpoint.api.services;

import udemy.spring.electronicpoint.api.entities.Company;

import java.util.Optional;

public interface CompanyService {

    /**
     *
     * Returns an company by its CNPJ
     *
     * @param cnpj The CNPJ from the request company
     * @return Optional<Company>
     */
    Optional<Company> findByCnpj(String cnpj);

    /**
     * Save a new company in the database
     *
     * @param company The company that is gonna be persisted
     * @return Company
     */
    Company save(Company company);

    /**
     * Receives a cnpj an returns true if is already in use
     *
     * @param cnpj The cnpj to be tested
     * @return Returns true if the cnpj is already in use or false if not
     */
    boolean isCnpjAlreadyInUse(String cnpj);

}
