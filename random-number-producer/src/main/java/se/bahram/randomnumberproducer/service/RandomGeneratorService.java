package se.bahram.randomnumberproducer.service;

import org.springframework.stereotype.Service;
import se.bahram.randomnumberproducer.models.WowNumber;

import java.util.Random;

@Service
public class RandomGeneratorService {

    public WowNumber random() {

        WowNumber wowNumber = new WowNumber();
        wowNumber.setWow(new Random().nextInt());

        return wowNumber;
    }
}
