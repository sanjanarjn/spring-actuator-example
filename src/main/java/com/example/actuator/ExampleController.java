package com.example.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/observe")
public class ExampleController {

    private ExampleService exampleService;

    private MetricsService metricsService ;

    public ExampleController(ExampleService exampleService, MetricsService metricsService) {
        this.exampleService = exampleService;
        this.metricsService = metricsService;
    }

    @GetMapping("/db")
    public void callDBService() {
        exampleService.getDataFromDatabase();
    }

    @GetMapping("/time")
    public String performUserOperation() {
        return metricsService.performUserOperation();
    }

    @GetMapping("/count")
    public String countUserOperations() {
        return metricsService.countUserOperations();
    }
}
