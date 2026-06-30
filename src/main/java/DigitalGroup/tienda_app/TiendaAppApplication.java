package DigitalGroup.tienda_app;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import DigitalGroup.tienda_app.service.ICardService;

@SpringBootApplication
public class TiendaAppApplication implements CommandLineRunner{

	@Autowired
		private ICardService cardService;
		private static final Logger  logger =  LoggerFactory.getLogger(TiendaAppApplication.class);
	public static void main(String[] args) {
		
		logger.info("Inciando Aplicacion tienda_app");
		SpringApplication.run(TiendaAppApplication.class, args);

		logger.info("Aplicacion finalizada");
	}
	@Override
	public void run(String... args) throws Exception {
		logger.info("Aplicacion Tienda_App");
	}

}
