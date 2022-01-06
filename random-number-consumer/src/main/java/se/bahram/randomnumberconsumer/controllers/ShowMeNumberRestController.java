package se.bahram.randomnumberconsumer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/show-me-a-number")
public class ShowMeNumberRestController {

    private final RestTemplate restTemplate;

    public ShowMeNumberRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    private String show() {
        Integer number = this.restTemplate.getForObject("http://localhost:8080/random/generate/", Integer.class);
        return "This is a number: " + number;
    }

}
