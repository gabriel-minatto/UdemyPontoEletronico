package udemy.spring.electronicpoint.api.services;

import udemy.spring.electronicpoint.api.entities.Empresa;

import java.util.Optional;

public interface EmpresaService {

    /**
     *
     * Returns an empresa by its CNPJ
     *
     * @param cnpj The CNPJ from the request empresa
     * @return Optional<Company>
     */
    Optional<Empresa> findByCnpj(String cnpj);

    /**
     * Save a new empresa in the database
     *
     * @param empresa The empresa that is gonna be persisted
     * @return Company
     */
    Empresa save(Empresa empresa);



}
