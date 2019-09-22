package udemy.spring.electronicpoint.api.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import udemy.spring.electronicpoint.api.entities.EntryPoint;
import udemy.spring.electronicpoint.api.repositories.EntryPointRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EntryPointServiceTest {

    @MockBean
    private EntryPointRepository entryPointRepository;

    @Autowired
    private EntryPointService entryPointService;

    private static Long ID = 1L;
    private static int PAGE = 0;
    private static int SIZE = 10;

    @Before
    public void setUp() {
        BDDMockito
                .given(entryPointRepository.findByEmployeeId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
                .willReturn(new PageImpl<>(new ArrayList<>()));
        BDDMockito.given(entryPointRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new EntryPoint()));
        BDDMockito.given(entryPointRepository.save(Mockito.any(EntryPoint.class))).willReturn(new EntryPoint());
    }

    @Test
    public void testFindByEmployeeId() {
        Page<EntryPoint> entryPoints = entryPointService.findByEmployeeId(ID, PageRequest.of(PAGE, SIZE));

        assertNotNull(entryPoints);
    }

    @Test
    public void testFindById() {
        Optional<EntryPoint> entryPoint = entryPointService.findById(ID);

        assertTrue(entryPoint.isPresent());
    }

    @Test
    public void testSave() {
        EntryPoint entryPoint = entryPointService.save(new EntryPoint());

        assertNotNull(entryPoint);
    }

}