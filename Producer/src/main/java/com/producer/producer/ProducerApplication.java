package com.producer.producer;

import com.producer.producer.entity.testEntityC;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(scanBasePackages = "com.producer.producer.config")
@RestController
@EnableTransactionManagement
@EnableEurekaClient
@EnableCaching
@EnableKafka
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @RequestMapping(value="/abb")
    public String abb(@RequestParam("test") String test){
        String a="bbbbbbbb";
        testEntityC aa =new testEntityC();
        return a;
    }
}
