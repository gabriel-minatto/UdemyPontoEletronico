package udemy.spring.electronicpoint.api.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.spring.electronicpoint.api.entities.Employee;
import udemy.spring.electronicpoint.api.repositories.EmployeeRepository;
import udemy.spring.electronicpoint.api.services.EmployeeService;

import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Optional<Employee> findByCpf(String cpf) {
        log.info("Searching employee by cpf {}", cpf);
        return Optional.ofNullable(employeeRepository.findByCpf(cpf));
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        log.info("Searching employee by email {}", email);
        return Optional.ofNullable(employeeRepository.findByEmail(email));
    }

    @Override
    public Optional<Employee> findById(Long id) {
        log.info("Searching employee by id {}", id);
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        log.info("Saving employee: {}", employee);
        return employeeRepository.save(employee);
    }

    @Override
    public boolean isCpfAlreadyInUse(String cpf) {
        log.info("Checking if cpf is already in use {}", cpf);
        return findByCpf(cpf).isPresent();
    }
}
