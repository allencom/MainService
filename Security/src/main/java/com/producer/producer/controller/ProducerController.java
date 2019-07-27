package com.producer.producer.controller;


import com.producer.producer.service.RedisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;



import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/produce")
public class ProducerController {

    private static Logger log = Logger.getLogger(ProducerController.class);

    @Autowired
    private RedisService redisService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String add(){
        log.info("===============>"+redisService.exists("123"));
        redisService.write("2222","12312312",5000);
        return"test";
        //return "produce1 add success";
    }
}
