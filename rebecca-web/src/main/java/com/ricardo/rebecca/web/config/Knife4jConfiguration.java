package com.ricardo.rebecca.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @ClassName Knife4jConfiguration
 * @Description 配置Knife4j
 * @Author RicardoC
 * @Date 2024/9/8 2:12
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Bean
    public Docket webApiDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Rebecca消息推送平台-用户端接口文档")
                .pathMapping("/")
                //定义是否开启Swagger，false是关闭，可以通过变量去控制，线上关闭
                .enable(true)
                //配置文档的元信息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ricardo.rebecca.web.controller"))
                //正则匹配请求路径，并分配到当前项目组
                //.paths(PathSelectors.ant("/api/**"))
                .build();
    }
//    @Bean
//    public Docket admin() {
//        return new Docket(DocumentationType.OAS_30)
//                .groupName("Rebecca消息推送平台-测试文档")
//                //定义是否开启Swagger，false是关闭，可以通过变量去控制，线上关闭
//                .enable(true)
//                //配置文档的元信息
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.ricardo.rebecca.web.controller"))
//                //正则匹配请求路径，并分配到当前项目组
//                //.paths(PathSelectors.ant("/api/**"))
//                .build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Rebecca平台")
                .description("消息推送接口接口文档")
                .contact(new Contact("Ricardo", "", "ricardo7chang@gamil.com"))
                .version("v1.0")
                .build();
    }

}
