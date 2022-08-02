package com.zhmenko.primeaspecttask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@OpenAPIDefinition
public class PrimeAspectTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrimeAspectTaskApplication.class, args);
    }

    @PostConstruct
    // Без этого свойства при повторном обращении к API restcountries возникает ошибка ssl рукопожатия
    public void initJVMProps() {
        System.setProperty("https.protocols","TLSv1.2,TLSv1.1,TLSv1");
    }
}
