package udemy.spring.electronicpoint.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import udemy.spring.electronicpoint.api.entities.PointEntry;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@Transactional(readOnly = true)
@NamedQueries({
        @NamedQuery(name = "PointEntryRepository.findByEmployeeId",
                query = "SELECT lanc FROM PointEntry lanc WHERE lanc.employee.id = :employeeId") })
public interface PointEntryRepository extends JpaRepository<PointEntry, Long> {

    List<PointEntry> findByEmployeeId(@Param("employeeId") Long employeeId);

    Page<PointEntry> findByEmployeeId(@Param("employeeId") Long employeeId, Pageable pageable);
}