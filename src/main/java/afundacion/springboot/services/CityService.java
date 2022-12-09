package afundacion.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import afundacion.springboot.entities.City;
import afundacion.springboot.model.CityRequest;
import afundacion.springboot.repositories.CityRepository;

/*
 * 
 * Clase de negocio encargada de hacer la funcionalidad solicitada
 * 
 */
@Service
public class CityService {

    //Inyectamos este componente de la capa repositorio en el constructor. La magia de Spring
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    public Long create(CityRequest newCountry) {
        City cityEntity = new City(newCountry.getName());
        return cityRepository.save(cityEntity).getId();
    }

    @Transactional
    public boolean update(Long id, CityRequest cityRequest) {
        return cityRepository.findById(id)
                .map(country -> {
                    copy(cityRequest, country);
                    return true;
                })
                .orElse(false);
    }

    private void copy(CityRequest cityRequest, City city) {
        city.setName(cityRequest.getName());
    }

    public void delete(Long id) {
        if (cityRepository.existsById(id)) {
        	cityRepository.deleteById(id);
        }
    }

}
