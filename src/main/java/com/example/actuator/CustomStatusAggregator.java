package com.example.actuator;

import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.actuate.health.StatusAggregator;

import java.util.Set;

public class CustomStatusAggregator implements StatusAggregator {

    @Override
    public Status getAggregateStatus(Set<Status> statuses) {
        // Add custom logic to aggregate all the statuses
        if (statuses.contains(Status.OUT_OF_SERVICE)) {
            return Status.OUT_OF_SERVICE;
        }
        return Status.UP;
    }
}
