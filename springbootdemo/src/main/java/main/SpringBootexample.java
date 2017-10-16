package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages={"com.ckv.*"})
@EnableJpaRepositories(basePackages={"com.ckv.*"})
@EntityScan("com.ckv.*")
@SpringBootApplication
public class SpringBootexample extends SpringBootServletInitializer{

	
	public static void main(String[] args) {

		SpringApplication.run(SpringBootexample.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootexample.class);
	}

}
