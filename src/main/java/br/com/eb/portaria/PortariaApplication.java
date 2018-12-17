package br.com.eb.portaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PortariaApplication extends SpringBootServletInitializer {

	@Override
    protected final SpringApplicationBuilder configure(
    		final SpringApplicationBuilder application) {
        return application.sources(PortariaApplication.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(PortariaApplication.class, args);
    }
}
