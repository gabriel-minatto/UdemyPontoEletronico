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
import udemy.spring.electronicpoint.api.entities.Company;
import udemy.spring.electronicpoint.api.repositories.CompanyRepository;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CompanyServiceTest {

    @MockBean
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    private static final String CNPJ = "51463645000100";

    @Before
    public void setUp() {
        BDDMockito.given(this.companyRepository.findByCnpj(Mockito.anyString())).willReturn(new Company());
        BDDMockito.given(this.companyRepository.save(Mockito.any(Company.class))).willReturn(new Company());
    }

    @Test
    public void testBuscarEmpresaPorCnpj() {
        Optional<Company> empresa = this.companyService.findByCnpj(CNPJ);

        assertTrue(empresa.isPresent());
    }

    @Test
    public void testSave() {
        Company company = this.companyService.save(new Company());

        assertNotNull(company);
    }
}