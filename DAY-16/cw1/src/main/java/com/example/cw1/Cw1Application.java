package com.example.cw1;

import com.example.cw1.service.EJIMyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Cw1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Cw1Application.class, args);
        EJIMyService myService = context.getBean(EJIMyService.class);
        myService.doSomething();
    }
}
