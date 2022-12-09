package afundacion.springboot.model;

import javax.validation.constraints.NotEmpty;

/**
 * POJO para nuestras peticiones al Controller
 * @author 
 *
 */
public class CityRequest {

    @NotEmpty
    private String name;

    public CityRequest() {
    }

    public CityRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
