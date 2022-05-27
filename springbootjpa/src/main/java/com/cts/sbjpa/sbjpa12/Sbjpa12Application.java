package com.cts.sbjpa.sbjpa12;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Products API", version = "2.0", description = "CTS ProductInformation"))
public class Sbjpa12Application {

    public static void main(String[] args) {
        SpringApplication.run(Sbjpa12Application.class, args);
    }

}
