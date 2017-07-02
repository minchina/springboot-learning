package org.ncmao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoogLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoogLearningApplication.class, args);
	}

//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//		return container -> {
//            container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
//            container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
//            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
//        };
//	}
}
