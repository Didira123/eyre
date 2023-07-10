//package br.com.eyre.eyre.config.swagger;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//public class SwaggerConfig {
//
//	@Bean
//	public Docket apis() {
//		return new Docket(DocumentationType.SWAGGER_2)
////				.ignoredParameterTypes(AuthenticationPrincipal.class)
////				.apiInfo(apiInfo())
////				.securitySchemes(Collections.singletonList(securitySchema()))
//				.select().apis(RequestHandlerSelectors.basePackage("br.com.eyre.eyre.api"))
//				.paths(PathSelectors.ant("/**")).build();
////				.globalOperationParameters(Arrays.asList(
////                        new ParameterBuilder()
////                                .name("Authorization")
////                                .description("Header para token JWT")
////                                .modelRef(new ModelRef("string"))
////                                .parameterType("header")
////                                .required(false)
////                                .build()));
//	}
//
//}
