package com.sandeep.TodoApp.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

        @GetMapping(path = "/basicauth")
        public String authSuccess() {
                return "success";
        }

        @GetMapping(path = "/helloworldbean/{name}")
        HelloWorldBean helloWorldBeanPath(@PathVariable String name) {
                return new HelloWorldBean((String.format("hello, %s!!", name)));
        }
}
