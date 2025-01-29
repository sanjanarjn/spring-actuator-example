package com.example.actuator;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Observed(name = "db.query",
            contextualName = "DB Query",
            lowCardinalityKeyValues = {"category", "db", "operation", "read"})
    public void getDataFromDatabase() {
        System.out.println("Retrieving data from db...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished retrieving data from db!!");
    }

    @Observed(name = "cache.query",
            contextualName = "Cache Query",
            lowCardinalityKeyValues = {"category", "cache", "operation", "read"})
    public void getDataFromCache() {
        System.out.println("Retrieving data from cache...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished retrieving data from cache!!");
    }

    @Observed(name = "api.call",
            contextualName = "API Call",
            lowCardinalityKeyValues = {"category", "api", "operation", "read"})
    public void getDataFromAPI() {
        System.out.println("Invoking API..");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Got response from API");
    }
}
