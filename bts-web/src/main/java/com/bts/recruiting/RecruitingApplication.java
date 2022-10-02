package com.bts.recruiting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources(value = {
        @PropertySource(value = "classpath:application.properties"),
        @PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
})
@ConfigurationPropertiesScan("com.bts.recruiting")
@SpringBootApplication
public class RecruitingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitingApplication.class, args);
    }


}
