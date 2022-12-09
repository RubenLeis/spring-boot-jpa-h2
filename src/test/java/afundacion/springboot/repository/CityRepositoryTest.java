package afundacion.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;


//import afundacion.springboot.repositories.CityRepository;

//FIXME
//@TestPropertySource(locations = "classpath:db-test.properties")
//@Sql("/test-h2-cities.sql") 
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class CityRepositoryTest {
//
//    @Autowired
//    CityRepository cityRepository;
//
//    @Test
//    void testFindAll() {
//        assertThat(cityRepository.findAll()).hasSize(3);
//    }
//
//}
