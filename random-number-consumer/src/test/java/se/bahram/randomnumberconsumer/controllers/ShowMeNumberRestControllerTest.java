package se.bahram.randomnumberconsumer.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.web.client.RestTemplate;
import se.bahram.randomnumberconsumer.models.WowNumber;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShowMeNumberRestControllerTest {
    @RegisterExtension
    public StubRunnerExtension stubRunner = new StubRunnerExtension()
            .downloadStub("se.bahram", "random-number-producer", "0.0.1-SNAPSHOT", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Test
    public void should_return_number() {
        // given:
        RestTemplate restTemplate = new RestTemplate();

        // when:
        WowNumber wowNumber = restTemplate.getForObject("http://localhost:8100/random/generate", WowNumber.class);

        // then:
        assertNotNull(wowNumber);
        assertEquals(123, wowNumber.getWow());
    }
}