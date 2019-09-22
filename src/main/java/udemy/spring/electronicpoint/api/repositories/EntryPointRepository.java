package udemy.spring.electronicpoint.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import udemy.spring.electronicpoint.api.entities.EntryPoint;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@Transactional(readOnly = true)
@NamedQueries({
        @NamedQuery(name = "EntryPointRepository.findByEmployeeId",
                query = "SELECT lanc FROM EntryPoint lanc WHERE lanc.employee.id = :employeeId") })
public interface EntryPointRepository extends JpaRepository<EntryPoint, Long> {

    List<EntryPoint> findByEmployeeId(@Param("employeeId") Long employeeId);

    Page<EntryPoint> findByEmployeeId(@Param("employeeId") Long employeeId, Pageable pageable);
}