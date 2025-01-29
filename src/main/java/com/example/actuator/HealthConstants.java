package com.example.actuator;

import org.springframework.boot.actuate.health.Status;

public class HealthConstants {


    public static final Status INCONSISTENT_CACHE = new Status("INCONSISTENT_CACHE", "Cache data is stale!");

    public static final Status UNSTABLE_SYSTEM_STATUS = new Status("UNSTABLE", "System is not stable!");;
}
