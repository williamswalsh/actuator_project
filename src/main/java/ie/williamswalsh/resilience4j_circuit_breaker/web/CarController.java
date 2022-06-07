package ie.williamswalsh.resilience4j_circuit_breaker.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping(value="/car")
    public String getCar() {
        return "Ferrari";
    }
}

