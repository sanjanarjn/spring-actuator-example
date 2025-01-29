package com.example.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("apiHealth")
public class ApiHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if(isApiHealthy()) {
            return Health.up().build();
        }
        else {
            return Health.down().build();
        }
    }

    private boolean isApiHealthy() {
        Random random = new Random();
        int randomValue = random.nextInt(100);
        return randomValue >= 10;
    }
}
