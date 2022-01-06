package se.bahram.randomnumberproducer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import se.bahram.randomnumberproducer.controllers.RandomNumberRestController;
import se.bahram.randomnumberproducer.models.WowNumber;
import se.bahram.randomnumberproducer.service.RandomGeneratorService;

@SpringBootTest(classes = RandomNumberProducerApplication.class)
public abstract class BaseTestClass {

    @Autowired
    private RandomNumberRestController randomNumberRestController;

    @MockBean
    private RandomGeneratorService randomGeneratorService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(randomNumberRestController);
        when(randomGeneratorService.random()).thenReturn(new WowNumber(123));
    }
}
