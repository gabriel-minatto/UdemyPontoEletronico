package udemy.spring.electronicpoint.api.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import udemy.spring.electronicpoint.api.entities.Employee;
import udemy.spring.electronicpoint.api.repositories.EmployeeRepository;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmployeeServiceTest {

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    private static Long ID = 1L;
    private static String EMAIL = "email@email.com";
    private static String CPF = "24291173474";

    @Before
    public void setUp() {
        BDDMockito.given(employeeRepository.save(Mockito.any(Employee.class))).willReturn(new Employee());
        BDDMockito.given(employeeRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Employee()));
        BDDMockito.given(employeeRepository.findByEmail(Mockito.anyString())).willReturn(new Employee());
        BDDMockito.given(employeeRepository.findByCpf(Mockito.anyString())).willReturn(new Employee());
    }

    @Test
    public void findByCpf() {
        Optional<Employee> employee = employeeService.findByCpf(CPF);

        assertTrue(employee.isPresent());
    }

    @Test
    public void findByEmail() {
        Optional<Employee> employee = employeeService.findByEmail(EMAIL);

        assertTrue(employee.isPresent());
    }

    @Test
    public void testFindById() {
        Optional<Employee> employee = employeeService.findById(ID);

        assertTrue(employee.isPresent());
    }

    @Test
    public void testSave() {
        Employee employee = employeeService.save(new Employee());

        assertNotNull(employee);

    }
}