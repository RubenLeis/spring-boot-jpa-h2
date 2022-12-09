package afundacion.springboot.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import afundacion.springboot.entities.Country;
import afundacion.springboot.model.CountryRequest;
import afundacion.springboot.repositories.CountryRepository;

import java.util.List;
import java.util.Optional;

/*
 * 
 * Clase de negocio encargada de hacer la funcionalidad solicitada
 * 
 */
@Service
public class CountryService {

    //Inyectamos este componente de la capa repositorio en el constructor. La magia de Spring
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    public Long create(CountryRequest newCountry) {
        Country countryEntity = new Country(newCountry.getName(), newCountry.getPopulation());
        return countryRepository.save(countryEntity).getId();
    }

    @Transactional
    public boolean update(Long id, CountryRequest countryRequest) {
        return countryRepository.findById(id)
                .map(country -> {
                    copy(countryRequest, country);
                    return true;
                })
                .orElse(false);
    }

    private void copy(CountryRequest countryRequest, Country country) {
        country.setName(countryRequest.getName());
        country.setPopulation(countryRequest.getPopulation());
    }

    public void delete(Long id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
        }
    }

}
