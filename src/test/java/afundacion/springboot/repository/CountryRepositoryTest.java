package afundacion.springboot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import afundacion.springboot.repositories.CountryRepository;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(locations = "classpath:db-test.properties") //configuramos contra que BBDD trabajaremos
@Sql("/test-h2-countries.sql") //indicamos el fichero que cargara datos en nuestra BBDD en memoria
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CountryRepositoryTest {

    @Autowired
    CountryRepository countryRepository;

    @Test
    void testFindAll() {
        assertThat(countryRepository.findAll()).hasSize(2);
    }

}
