package kz.iitu.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("kz.iitu.library"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "CarService API",
                "CarService Application API for IITU",
                "0.01",
                "https://www.google.com",
                new springfox.documentation.service.Contact("Zhaskanat","https://www.google.com", "zhasy99@mail.ru"),
                "API CarService License",
                "https://www.google.com",
                Collections.emptyList());
    }
}