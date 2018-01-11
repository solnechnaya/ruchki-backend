package com.nata.ruchki.controller;

import com.nata.ruchki.data.repository.TestRepo;
import com.nata.ruchki.data.value.TestValue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class HelloControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Autowired
    public TestRepo repo;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/hello/1");
        repo.save(new com.nata.ruchki.data.entity.Test("message"));
    }

    @Test
    public void getHello() {
        ResponseEntity<TestValue> response = template.getForEntity(base.toString(), TestValue.class);
        assertEquals(response.getBody(), new TestValue(1L,"message"));
    }


}
