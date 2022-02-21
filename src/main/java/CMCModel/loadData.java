package CMCModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class loadData {

	private static final Logger log = LoggerFactory.getLogger(loadData.class);

	@Bean
	CommandLineRunner initDatabase(CustomerRepo repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Customer("Abhishek", "Chachadi", 22, "M", "Belagavi")));
		};
	}
}
