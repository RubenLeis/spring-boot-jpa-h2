package afundacion.springboot.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

//import afundacion.springboot.repositories.CityRepository;


/**
 * Test para validar el funcionamiento de CityService
 * En este caso realizamos el mock de nuestro repositorio, haciendo que devuelva nulo
 * @author 
 *
 */
//@SpringBootTest
//@TestPropertySource(locations = "classpath:db-test.properties")
//class CityServiceMockAnnotationTest {
//
//    @MockBean
//    CityRepository cityRepository;
//
//    @Autowired
//    CityService cityService;
//
//    @Test
//    void testFindAllEmptyResponse() {
//        when(cityRepository.findAll()).thenReturn(Collections.emptyList());
//
//        assertThat(cityRepository.findAll()).isEmpty();
//    }
//
//}
