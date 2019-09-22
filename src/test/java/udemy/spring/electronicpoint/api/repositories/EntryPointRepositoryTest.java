package udemy.spring.electronicpoint.api.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import udemy.spring.electronicpoint.api.entities.Company;
import udemy.spring.electronicpoint.api.entities.Employee;
import udemy.spring.electronicpoint.api.entities.EntryPoint;
import udemy.spring.electronicpoint.api.enums.ProfileEnum;
import udemy.spring.electronicpoint.api.enums.TypeEnum;
import udemy.spring.electronicpoint.api.utils.PasswordUtils;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EntryPointRepositoryTest {

    @Autowired
    private EntryPointRepository entryPointRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    private Long funcionarioId;

    @Before
    public void setUp() {
        Company company = this.companyRepository.save(obterDadosEmpresa());

        Employee employee = this.employeeRepository.save(obterDadosFuncionario(company));
        this.funcionarioId = employee.getId();

        this.entryPointRepository.save(obterDadosLancamentos(employee));
        this.entryPointRepository.save(obterDadosLancamentos(employee));
    }

    @After
    public void tearDown() {
        this.companyRepository.deleteAll();
    }

    @Test
    public void testBuscarLancamentosPorFuncionarioId() {
        List<EntryPoint> entries = this.entryPointRepository.findByEmployeeId(funcionarioId);

        assertEquals(2, entries.size());
    }

    @Test
    public void testBuscarLancamentosPorFuncionarioIdPaginado() {
        PageRequest page = PageRequest.of(0, 10);
        Page<EntryPoint> lancamentos = this.entryPointRepository.findByEmployeeId(funcionarioId, page);

        assertEquals(2, lancamentos.getTotalElements());
    }

    private EntryPoint obterDadosLancamentos(Employee employee) {
        EntryPoint entryPoint = new EntryPoint();
        entryPoint.setData(new Date());
        entryPoint.setTipo(TypeEnum.INICIO_ALMOCO);
        entryPoint.setEmployee(employee);
        return entryPoint;
    }

    private Employee obterDadosFuncionario(Company company) {
        Employee employee = new Employee();
        employee.setNome("Fulano de Tal");
        employee.setPerfil(ProfileEnum.ROLE_USUARIO);
        employee.setSenha(PasswordUtils.gerarBCrypt("123456"));
        employee.setCpf("24291173474");
        employee.setEmail("email@email.com");
        employee.setCompany(company);
        return employee;
    }

    private Company obterDadosEmpresa() {
        Company company = new Company();
        company.setRazaoSocial("Company de exemplo");
        company.setCnpj("51463645000100");
        return company;
    }

}