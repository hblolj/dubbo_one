package com.hblolj.dubbo.one.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: hblolj
 * @Date: 2019/7/3 11:06
 * @Description:
 * @Version:
 **/
@SpringBootApplication
@ImportResource(value = {"classpath:spring/spring-jdbc.xml", "classpath:spring/spring-dubbo.xml"})
@MapperScan(basePackages = "com.hblolj.dubbo.one.model.mapper")
public class BootMoreApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootMoreApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BootMoreApplication.class, args);
    }
}
