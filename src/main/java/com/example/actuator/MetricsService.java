package com.example.actuator;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MetricsService {

    private final AtomicInteger activeUsers = new AtomicInteger(0);


    private final MeterRegistry meterRegistry;

    @Autowired
    public MetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        Timer timer = Timer
                .builder("my.custom.timer")
                .description("Time taken for user operation")
                .register(meterRegistry);


    }

    @Timed(value = "my.custom.timer", description = "Time taken for user operation")
    public String performUserOperation() {

        meterRegistry.get("my.custom.timer").timer().record(() -> {
            try {

                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });  // Debug if it's registered

        return "User operation performed";
    }

    @Counted(value = "my.custom.counter", description = "Number of times the user operation is invoked")
    public String countUserOperations() {
        meterRegistry.get("my.custom.counter").counter();
        return "User operation count incremented";
    }

}