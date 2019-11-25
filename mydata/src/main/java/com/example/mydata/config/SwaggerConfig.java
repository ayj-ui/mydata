package com.example.mydata.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类
 * @Author: yuanj
 * @Date: 2018/9/17 13:43
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "msg-config", name = "swagger-open", havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))                      //这里采用包含注解的方式来确定要显示的接口
                //.apis(RequestHandlerSelectors.basePackage("com.moerlong.service_authorize.controller"))    //这里采用包扫描的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MoerService Gateway Doc")                       //标题
                .description("摩尔服务授权网关 Api文档")                  //描述
                .termsOfServiceUrl("http://www.moerlong.com")           //条款地址（不可见）
                .contact("moerlong")                                    //作者信息
                .version("1.0")                                         //版本号
                .build();
    }

}
