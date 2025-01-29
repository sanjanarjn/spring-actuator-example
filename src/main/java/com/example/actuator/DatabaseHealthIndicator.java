package com.example.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("dbHealth")
public class DatabaseHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if(isDatabaseHealthy()) {
            return Health.up().build();
        }
        else {
            return Health.down().build();
        }
    }

    private boolean isDatabaseHealthy() {
        return true;
    }
}
