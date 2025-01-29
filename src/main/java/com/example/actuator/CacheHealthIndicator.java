package com.example.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("cacheHealth")
public class CacheHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (isCacheHealthy()) {
            return Health.up().build();
        }
        else {
            return Health.status(HealthConstants.INCONSISTENT_CACHE).build();
        }
    }

    private boolean isCacheHealthy() {
        Random random = new Random();
        int randomValue = random.nextInt(100);
        return randomValue >= 25;
    }
}
