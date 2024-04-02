package co.com.puerta.microservice.resolveEnigmaApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "co.com.puerta.microservice.resolveEnigmaApi", "co.com.puerta.microservice.resolveEnigmaApi.api" , "co.com.puerta.microservice.resolveEnigmaApi.config"})
public class ResolveEnigmaApplication{

    public static void main(String[] args) throws Exception {
        new SpringApplication(ResolveEnigmaApplication.class).run(args);
    }

  
    }

