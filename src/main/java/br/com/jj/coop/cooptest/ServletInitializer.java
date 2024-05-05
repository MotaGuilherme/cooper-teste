package br.com.jj.coop.cooptest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Slf4j
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CoopTestApplication.class);
	}

	protected static void onApplicationLoaded(ConfigurableApplicationContext ctx) {
		final var env = ctx.getEnvironment();
		try {
			final var banco = env.getProperty("spring.datasource.url");
			final var serverPort = Optional.ofNullable(env.getProperty("server.port")).orElse("8080");
			final var contextPath = Optional.ofNullable(env.getProperty("server.servlet.context-path")).orElse(StringUtils.EMPTY);
			final var hostAddress = InetAddress.getLocalHost().getHostAddress();
			final var serverAddress = serverPort + contextPath;

			final var ascii = loadAsciiArt(ctx);

			log.error(StringUtils.LF +
							StringUtils.LF +
							ascii +
							StringUtils.LF +
							StringUtils.LF +
							"***" +
							StringUtils.LF +
							StringUtils.LF +
							"\tAplicação {} iniciada com sucesso!\n" +
							"\tDisponível nos endereços:\n" +
							"\tLocal: http://localhost:{} \n" +
							"\tExterno: http://{}:{} \n" +
							"\tSwagger: http://{}:{} \n" +
							"\tLocal Swagger: http://localhost:{} \n" +
							"\tURL JDBC: {} \n" +
							StringUtils.LF +
							"***" +
							StringUtils.LF +
							StringUtils.LF +
							StringUtils.LF,
					env.getProperty("spring.application.name"),
					serverAddress,
					hostAddress,
					serverAddress,
					hostAddress,
					serverAddress + "/swagger-ui.html",
					serverAddress + "/swagger-ui.html",
					banco);

		} catch (IOException e) {
			log.error("Falha ao executar aplicação...", e);
			ctx.close();
		}
	}

	private static String loadAsciiArt(ApplicationContext ctx) {
		try (final var is = ctx.getResource("classpath:/banner.txt").getInputStream()) {
			return IOUtils.toString(is, StandardCharsets.UTF_8);
		} catch (IOException e) {
			return StringUtils.EMPTY;
		}
	}
}
