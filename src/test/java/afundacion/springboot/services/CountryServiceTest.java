package afundacion.springboot.services;

import afundacion.springboot.Dataset;
import afundacion.springboot.entities.Country;
import afundacion.springboot.services.CountryService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test para validar el funcionamiento de CountryService
 * En este caso trabajamos con una BBDD en memoria indicada en el fichero sql
 * @author 
 *
 */
@SpringBootTest(properties = {"spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"})
@Sql("/test-h2-countries.sql") //indicamos el fichero que cargara datos en nuestra BBDD en memoria
@AutoConfigureTestDatabase
class CountryServiceTest {

    @Autowired
    CountryService countryService;

    @Test
    void testFindAll() {
        List<Country> countries = countryService.findAll();

        assertThat(countries)
                .extracting(Country::getName)
                .containsExactlyInAnyOrder(
                        Dataset.NAME_MEXICO,
                        Dataset.NAME_SPAIN);
    }

}
