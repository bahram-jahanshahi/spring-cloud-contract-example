package se.bahram.randomnumberproducer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.bahram.randomnumberproducer.models.WowNumber;
import se.bahram.randomnumberproducer.service.RandomGeneratorService;

import java.util.Random;

@RestController
@RequestMapping("/random")
public class RandomNumberRestController {

    private final RandomGeneratorService randomGeneratorService;

    public RandomNumberRestController(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @GetMapping("/generate")
    public WowNumber generate() {
        return this.randomGeneratorService.random();
    }
}
