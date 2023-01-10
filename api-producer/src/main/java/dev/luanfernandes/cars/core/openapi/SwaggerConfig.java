package dev.luanfernandes.cars.core.openapi;

import com.fasterxml.classmate.TypeResolver;

import dev.luanfernandes.cars.api.exceptions.handler.StandardError;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket apiDocketV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("dev.luanfernandes.cars.api.v1"))
                .build()
                .useDefaultResponseMessages(false)
                .additionalModels(new TypeResolver().resolve(StandardError.class))
                .globalResponses(HttpMethod.GET, globalResponseMessages())
                .apiInfo(apiInfoV1())
                .tags(
                        new Tag("Cars", "Service Car",0),
                        new Tag("Logs", "Service Logs",1)
                );
    }

    private List<Response> globalResponseMessages() {
        final String PROBLEMA = "Problema";
        return List.of(
                new ResponseBuilder()
                        .code("400")
                        .description("Requisição inválida. Erro do cliente")
                        .representation(MediaType.APPLICATION_JSON)
                        .apply(r -> r.model(m -> m.referenceModel(rm -> rm.key(k -> k.qualifiedModelName(
                                q -> q.namespace(StandardError.class.getPackageName())
                                        .name(PROBLEMA)))))).build(),
                new ResponseBuilder()
                        .code("500")
                        .description("Erro interno no servidor")
                        .representation(MediaType.APPLICATION_JSON)
                        .apply(r -> r.model(m -> m.referenceModel(rm -> rm.key(k -> k.qualifiedModelName(
                                q -> q.namespace(StandardError.class.getPackageName())
                                        .name(PROBLEMA)))))).build(),
                new ResponseBuilder()
                        .code("406")
                        .description("Recurso não possui representação que poderia ser aceita pelo consumidor")
                        .representation(MediaType.APPLICATION_JSON)
                        .apply(r -> r.model(m -> m.referenceModel(rm -> rm.key(k -> k.qualifiedModelName(
                                q -> q.namespace(StandardError.class.getPackageName())
                                        .name(PROBLEMA)))))).build(),
                new ResponseBuilder()
                        .code("415")
                        .description("Requisição recusada porque o corpo está em um formato não suportado")
                        .representation(MediaType.APPLICATION_JSON)
                        .apply(r -> r.model(m -> m.referenceModel(rm -> rm.key(k -> k.qualifiedModelName(
                                q -> q.namespace(StandardError.class.getPackageName())
                                        .name(PROBLEMA)))))).build()
        );
    }
    private ApiInfo apiInfoV1() {
        return new ApiInfo(
                "Carros API", "Desafio consumer api externa", "v1.0", "",
                new Contact("Paulo Bof",
                        "https://www.linkedin.com/in/paulobof",
                        "luan.santos@luizalabs.com"), "", "", Collections.emptyList());
    }
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/swagger-ui/index.html");
        registry.addRedirectViewController("/swagger-ui", "/swagger-ui/index.html");
    }
}