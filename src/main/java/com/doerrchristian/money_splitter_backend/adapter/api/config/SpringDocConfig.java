package com.doerrchristian.money_splitter_backend.adapter.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("MoneyCalculation API")
                                .version("1.0.0")
                );
    }

    @Bean
    public GroupedOpenApi serviceAPI() {
        return GroupedOpenApi
                .builder()
                .group("moneycalculation")
                .packagesToScan("com.doerrchristian.money_splitter_backend")
                .build();
    }
}
