package afundacion.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import afundacion.springboot.entities.City;

/*
 * Clase encargada de recuperar la información de BBDD
 */
public interface CityRepository extends JpaRepository<City, Long> {

}
