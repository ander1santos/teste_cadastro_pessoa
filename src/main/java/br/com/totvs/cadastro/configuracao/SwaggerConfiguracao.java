package br.com.totvs.cadastro.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguracao {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
        		.apis(RequestHandlerSelectors.basePackage("br.com.totvs.cadastro"))
        		.paths(PathSelectors.ant("/api/**"))
        		.build()
        		.apiInfo(apiInfo());
    }
	
	private ApiInfo apiInfo() {
		Contact contato = new Contact("Totvs", "https://www.totvs.com.br/", "contato@totvs.com.br");
		
		return new ApiInfoBuilder()
				.title("Cadastro de Pessoa")
				.version("1.0")
				.contact(contato)
				.build();		
	}
	
}
