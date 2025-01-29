package com.example.actuator;

import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.actuate.health.StatusAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class HealthConfiguration {

    @Bean
    public StatusAggregator customStatusAggregator() {

        return new StatusAggregator() {
            @Override
            public Status getAggregateStatus(Set<Status> statuses) {
                if (statuses.contains(Status.DOWN)) {
                    return Status.DOWN;
                }
                if (statuses.contains(Status.OUT_OF_SERVICE)) {
                    return Status.OUT_OF_SERVICE;
                }
                if(statuses.contains(HealthConstants.INCONSISTENT_CACHE)) {
                    return HealthConstants.UNSTABLE_SYSTEM_STATUS;
                }
                return Status.UP; // Custom logic
            }
        };
    }
}
