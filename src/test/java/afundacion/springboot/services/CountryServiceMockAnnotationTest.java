package afundacion.springboot.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import afundacion.springboot.repositories.CountryRepository;
import afundacion.springboot.services.CountryService;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


/**
 * Test para validar el funcionamiento de CountryService
 * En este caso realizamos el mock de nuestro repositorio, haciendo que devuelva nulo
 * @author Ruben
 *
 */
@SpringBootTest
@TestPropertySource(locations = "classpath:db-test.properties")
class CountryServiceMockAnnotationTest {

    @MockBean
    CountryRepository countryRepository;

    @Autowired
    CountryService countryService;

    @Test
    void testFindAllEmptyResponse() {
        when(countryRepository.findAll()).thenReturn(Collections.emptyList());

        assertThat(countryService.findAll()).isEmpty();
    }

}
