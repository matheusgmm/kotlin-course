package br.com.muccio.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig {

    @Bean
    fun api(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Mercado Livro")
                    .version("v1")
                    .description("")
            )
            .servers(listOf(
                Server().url("https://localhost:8080").description("localhost")
            ))
    }
}