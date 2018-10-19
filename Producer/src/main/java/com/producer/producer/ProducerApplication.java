package com.producer.producer;

import com.producer.producer.entity.testEntityC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@EnableEurekaClient
@SpringBootApplication
@Controller
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @RequestMapping(value="/abb")
    @ResponseBody
    public String abb(){
        String a="bbbbbbbb";

        testEntityC aa =new testEntityC();



        return a;

    }
}
