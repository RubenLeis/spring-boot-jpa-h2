package afundacion.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Clase encargada de arrancar nuestra app
 * 
 * Se ejecuta como cualquier app de Java con un main
 *
 */
@SpringBootApplication
public class StartApp extends SpringBootServletInitializer /*implements CommandLineRunner*/ {

	/**
	 * Starts our app
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }


}
