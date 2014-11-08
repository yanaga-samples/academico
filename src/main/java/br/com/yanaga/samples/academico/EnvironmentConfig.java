package br.com.yanaga.samples.academico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class EnvironmentConfig {

	@Autowired
	private Environment env;

	@Bean
	public URI databaseUri() {
		try {
			return new URI(env.getProperty("DATABASE_URL", "postgres://postgres:postgres@localhost/postgres"));
		}
		catch (URISyntaxException e) {
			throw new IllegalStateException("DATABASE_URL mal formada", e);
		}
	}

}
