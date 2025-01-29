package com.example.actuator;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

@Component
@WebEndpoint(id="custom")
public class CustomEndpoint {

    @ReadOperation
    public String readCustomValue() {
        return "This is a custom endpoint";
    }
}
