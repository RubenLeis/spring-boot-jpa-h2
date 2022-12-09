package afundacion.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import afundacion.springboot.entities.Country;

/*
 * Clase encargada de recuperar la información de BBDD
 */
public interface CountryRepository extends JpaRepository<Country, Long> {

}
