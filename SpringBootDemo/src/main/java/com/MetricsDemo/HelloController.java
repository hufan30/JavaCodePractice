package com.MetricsDemo;


import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    MeterRegistry meterRegistry;

    @Autowired
    public HelloController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/hello")
    public void hello() {
        Metrics.gauge("user.test.gauge", 3);
    }

    @GetMapping("/hello2")
    public void hello2() {
        meterRegistry.gauge("测试meterRegistry", 3);
    }
}

