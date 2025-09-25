package com.vaadin.starter.bakery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vaadin.starter.bakery.app.security.SecurityConfiguration;
import com.vaadin.starter.bakery.backend.data.entity.User;
import com.vaadin.starter.bakery.backend.repositories.UserRepository;
import com.vaadin.starter.bakery.backend.service.UserService;
import com.vaadin.starter.bakery.ui.MainView;

/**
 * Main entry point for the Bakery application.
 * <p>
 * This class bootstraps the Spring Boot application, configures the base
 * packages for component scanning, JPA repositories, and entity classes, and
 * acts as the initializer when deployed as a traditional WAR in a servlet
 * container.
 * </p>
 *
 * <h2>Configuration</h2>
 * <ul>
 *   <li>{@link SpringBootApplication} — specifies the base packages to scan for
 *   Spring components, services, security, and UI views, while excluding
 *   {@link ErrorMvcAutoConfiguration} since Vaadin handles its own error views.</li>
 *   <li>{@link EnableJpaRepositories} — enables Spring Data JPA repositories,
 *   scanning for interfaces like {@link UserRepository}.</li>
 *   <li>{@link EntityScan} — configures the entity scanning to include JPA
 *   entities such as {@link User}.</li>
 * </ul>
 *
 * <h2>Deployment</h2>
 * This class extends {@link SpringBootServletInitializer}, making it compatible
 * with deployment in external servlet containers (e.g., Tomcat) in addition to
 * running as a standalone JAR.
 */
@SpringBootApplication(
		scanBasePackageClasses = {
				SecurityConfiguration.class,
				MainView.class,
				Application.class,
				UserService.class
		},
		exclude = ErrorMvcAutoConfiguration.class
)
@EnableJpaRepositories(basePackageClasses = { UserRepository.class })
@EntityScan(basePackageClasses = { User.class })
public class Application extends SpringBootServletInitializer {

	/**
	 * Application entry point when running as a standalone Java application.
	 *
	 * @param args command-line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Configures the application when deployed as a WAR file to a servlet container.
	 * This method registers {@code Application.class} as the primary source
	 * for Spring configuration.
	 *
	 * @param application the {@link SpringApplicationBuilder} used to configure the app
	 * @return the configured {@link SpringApplicationBuilder} instance
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}