package udemy.spring.electronicpoint.api.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import udemy.spring.electronicpoint.api.entities.Company;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    private static final String CNPJ = "51463645000100";

    @Before
    public void setUp() {
        Company company = new Company();
        company.setCorporateName("Company de exemplo");
        company.setCnpj(CNPJ);
        this.companyRepository.save(company);
    }

    @After
    public final void tearDown() {
        this.companyRepository.deleteAll();
    }

    @Test
    public void testBuscarPorCnpj() {
        Company company = this.companyRepository.findByCnpj(CNPJ);

        assertEquals(CNPJ, company.getCnpj());
    }

}