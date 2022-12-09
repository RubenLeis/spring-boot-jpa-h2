package afundacion.springboot.controllers;

import static afundacion.springboot.Dataset.SPAIN_ID;
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

import afundacion.springboot.entities.Country;
import afundacion.springboot.services.CountryService;

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
@WebMvcTest(CountryRestController.class)
class CountryRestControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(CountryRestControllerTest.class);

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    CountryService countryService;

    @Test
    void testGetSpain() throws Exception {

    	//Convertimos en mock/fake nuestro countryService y hacemos que si preguntan por el ID de España, se devuelva una constante, el pais España
    	//Asi evitamos llamadas a BBDD u otros componentes encargados de a partir de un id obtener un pais.
        Mockito.when(countryService.findById((long) SPAIN_ID)).thenReturn(Optional.of(new Country("Spain", 0)));

        //Comprobamos que si buscamos el pais con ID 2, nos devuelva España
        String response = mockMvc.perform(get(CountryRestController.COUNTRIES_RESOURCE + "/{id}/", SPAIN_ID))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.name", is("Spain")))
                .andReturn().getResponse()
                .getContentAsString();
        
        logger.info("response: " + response);
        
    }
    

}
