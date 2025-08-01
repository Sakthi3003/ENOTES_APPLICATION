package com.enotes.Enotes;


import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.apache.logging.log4j.LogManager;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAware")
public class EnotesApplication {
	//private static final Logger logger = LoggerFactory.getLogger(EnotesApplication.class);
	private static final Logger logger = LogManager.getLogger(EnotesApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(EnotesApplication.class, args);
		logger.info("hi");
		logger.debug("hello");
	}

}
