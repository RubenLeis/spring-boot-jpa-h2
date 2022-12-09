package afundacion.springboot.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import afundacion.springboot.entities.City;
import afundacion.springboot.model.CityRequest;
import afundacion.springboot.services.CityService;

/**
 * Rest endpoint API
 * 
 * Clase encargada de recoger las peticiones HTTP y llamar a la logica de negocio (service)
 *
 */
// Anotacion para indicar que es un EndPoint con la URL correspondiente en requestMapping
@RestController
@RequestMapping(CityRestController.CITIES_RESOURCE)
public class CityRestController {

    public static final String CITIES_RESOURCE = "/api/cities";

    //Inyectamos este componente de capa servicio en el constructor. La magia de Spring
    private final CityService cityService;

    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAll() {
        return cityService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> getById(@PathVariable Long id) {
        return cityService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> add(@RequestBody @Valid CityRequest city) {
        Long id = cityService.create(city);
        return new ResponseEntity<>(Collections.singletonMap("id", id), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody @Valid CityRequest cityRequest) {
        boolean wasUpdated = cityService.update(id, cityRequest);
        return wasUpdated ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	cityService.delete(id);
    }

}
