package afundacion.springboot.controllers;

import static afundacion.springboot.Dataset.VIGO_ID;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import afundacion.springboot.entities.City;
import afundacion.springboot.services.CityService;

/**
 * Test para validar CountryRestController
 * 
 * Estamos mockeando CountryService. De esta manera en CountryRestController se
 * utilizará este "fake" para devolver lo que nos de la gana y evitar llamadas a
 * otros componentes, en este caso a CountryService.
 * 
 * No nos interesa probar esos componentes, ya los hemos validado en otros test
 * 
 * @author
 *
 */
@WebMvcTest(CityRestController.class)
class CityRestControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(CityRestController.class);

    @Autowired
    private MockMvc mockMvc;


    @MockBean	
    CityService cityService;

    @Test
    void testGetSpain() throws Exception {

    	//Hacemos mock de cityService
        Mockito.when(cityService.findById((long) VIGO_ID)).thenReturn(Optional.of(new City("Vigo")));

        //Comprobamos que si buscamos el pais con ID 21, nos devuelva la ciudad de Vigo
        String response = mockMvc.perform(get(CityRestController.CITIES_RESOURCE + "/{id}/", VIGO_ID))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.name", is("Vigo")))
                .andReturn().getResponse()
                .getContentAsString();
        
        logger.info("response: " + response);
        
    }
    

}
