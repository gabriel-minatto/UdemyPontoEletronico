package udemy.spring.electronicpoint.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.spring.electronicpoint.api.entities.Empresa;
import udemy.spring.electronicpoint.api.repositories.EmpresaRepository;
import udemy.spring.electronicpoint.api.services.EmpresaService;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public Optional<Empresa> findByCnpj(String cnpj) {
        log.info("Buscando uma empresa para o CNPJ {}", cnpj);
        return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
    }

    @Override
    public Empresa save(Empresa empresa) {
        log.info("Persistindo empresa: {}", empresa);
        return this.empresaRepository.save(empresa);
    }
}
