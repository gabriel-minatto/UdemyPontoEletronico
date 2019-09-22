package udemy.spring.electronicpoint.api.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import udemy.spring.electronicpoint.api.entities.EntryPoint;
import udemy.spring.electronicpoint.api.repositories.EntryPointRepository;
import udemy.spring.electronicpoint.api.services.EntryPointService;

import java.util.Optional;

@Slf4j
@Service
public class EntryPointServiceImpl implements EntryPointService {

    private final EntryPointRepository entryPointRepository;

    @Autowired
    public EntryPointServiceImpl(EntryPointRepository entryPointRepository) {
        this.entryPointRepository = entryPointRepository;
    }

    @Override
    public Page<EntryPoint> findByEmployeeId(Long employeeId, PageRequest pageRequest) {
        log.info("Searching entrypoints by employee's ID {}", employeeId);
        return entryPointRepository.findByEmployeeId(employeeId, pageRequest);
    }

    @Override
    public Optional<EntryPoint> findById(Long id) {
        log.info("Searching an entrypoint by ID {}", id);
        return entryPointRepository.findById(id);
    }

    @Override
    public EntryPoint save(EntryPoint entrypoint) {
        log.info("Saving an entrypoint: {}", entrypoint);
        return entryPointRepository.save(entrypoint);
    }

    @Override
    public void delete(Long id) {
        log.info("Removing an entrypoint by ID {}", id);
        entryPointRepository.deleteById(id);

    }
}
