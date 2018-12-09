package com.jtj.restdocdocsify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RestdocDocsifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestdocDocsifyApplication.class, args);
    }

    @GetMapping("/")
    public String index(){
        return "Server is running!";
    }

    @GetMapping("/user")
    public User user(){
        return new User("Jone",1,20);
    }

}
