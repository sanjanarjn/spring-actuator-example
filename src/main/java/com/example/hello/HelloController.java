package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    public String greeting(@PathVariable("name") String name) {
        return MessageFormat.format("Hello there, {0}! How are you doing today?", name);
    }
}
