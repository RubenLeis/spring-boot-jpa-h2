package afundacion.springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import afundacion.springboot.entities.Country;
import afundacion.springboot.model.CountryRequest;
import afundacion.springboot.services.CountryService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Rest endpoint API
 * 
 * Clase encargada de recoger las peticiones HTTP y llamar a la logica de negocio (service)
 *
 */
// Anotacion para indicar que es un EndPoint con la URL correspondiente en requestMapping
@RestController
@RequestMapping(CountryRestController.COUNTRIES_RESOURCE)
public class CountryRestController {

    public static final String COUNTRIES_RESOURCE = "/api/countries";

    //Inyectamos este componente de capa servicio en el constructor. La magia de Spring
    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAll() {
        return countryService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Country> getById(@PathVariable Long id) {
        return countryService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> add(@RequestBody @Valid CountryRequest country) {
        Long id = countryService.create(country);
        return new ResponseEntity<>(Collections.singletonMap("id", id), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody @Valid CountryRequest countryRequest) {
        boolean wasUpdated = countryService.update(id, countryRequest);
        return wasUpdated ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        countryService.delete(id);
    }

}
