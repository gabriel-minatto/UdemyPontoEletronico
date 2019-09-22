package udemy.spring.electronicpoint.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import udemy.spring.electronicpoint.api.entities.EntryPoint;

import java.util.Optional;

public interface EntryPointService {

    /**
     * Returns an EntryPoints paginated list by EmployeeId
     *
     * @param employeeId entrypoints owner/employee
     * @param pageRequest Pageable object
     * @return Page<Employee>
     */
    Page<EntryPoint> findByEmployeeId(Long employeeId, PageRequest pageRequest);

    /**
     * Returns an EntryPoint by ID
     *
     * @param id EntryPoint's id
     * @return Optional<Employee>
     */
    Optional<EntryPoint> findById(Long id);

    /**
     * Saves an EntryPoint in the database
     *
     * @param entrypoint The saved entrypoint.
     * @return Employee
     */
    EntryPoint save(EntryPoint entrypoint);

    /**
     * Remove an EntryPoint from database by ID
     *
     * @param id EntryPoint's id
     */
    void delete(Long id);
}
