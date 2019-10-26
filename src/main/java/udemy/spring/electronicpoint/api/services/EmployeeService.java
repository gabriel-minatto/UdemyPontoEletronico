package udemy.spring.electronicpoint.api.services;

import udemy.spring.electronicpoint.api.entities.Employee;

import java.util.Optional;

public interface EmployeeService {


    /**
     * Search and returns an employee by CPF
     *
     * @param cpf CPF from searched user
     * @return Optional<Employee>
     */
    Optional<Employee> findByCpf(String cpf);

    /**
     * Search and returns an employee by EMAIL
     *
     * @param email EMAIL from searched user
     * @return Optional<Employee>
     */
    Optional<Employee> findByEmail(String email);

    /**
     * Search and returns an employee by ID
     *
     * @param id ID from searched user
     * @return Optional<Employee>
     */
    Optional<Employee> findById(Long id);

    /**
     * Save a new employee in the database
     *
     * @param employee The employee that is gonna be persisted
     * @return Employee
     */
    Employee save(Employee employee);

    /**
     * Receives a cpf an returns true if is already in use
     *
     * @param cpf The cpf to be tested
     * @return Returns true if the cpf is already in use or false if not
     */
    boolean isCpfAlreadyInUse(String cpf);

}
