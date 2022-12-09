package afundacion.springboot.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import afundacion.springboot.Dataset;
import afundacion.springboot.entities.City;

/**
 * Test para validar el funcionamiento de CountryService
 * En este caso trabajamos con una BBDD en memoria indicada en el fichero sql
 * @author 
 *
 */
@SpringBootTest(properties = {"spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"})
@Sql("/test-h2-cities.sql") //indicamos el fichero que cargara datos en nuestra BBDD en memoria
@AutoConfigureTestDatabase
class CityServiceTest {

    @Autowired
    CityService cityService;

    @Test
    void testFindAll() {
        List<City> cities = cityService.findAll();

        assertThat(cities)
                .extracting(City::getName)
                .containsExactlyInAnyOrder(
                        Dataset.NAME_CIUDAD_JUAREZ,
                        Dataset.NAME_VIGO,
                        Dataset.NAME_LUGO);
    }

}
