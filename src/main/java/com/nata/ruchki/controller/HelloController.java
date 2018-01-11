package com.nata.ruchki.controller;

import com.nata.ruchki.data.service.TestService;
import com.nata.ruchki.data.value.Model;
import com.nata.ruchki.data.value.TestValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private TestService testService;

    public HelloController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST, consumes = {"application/json"})
    public long setValue(@RequestBody TestValue testValue) {
        return testService.add(testValue);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, consumes = {"application/json"})
    public Model<String> testPost(@RequestBody Model<String> testValue) {
        logger.debug("Added {}",testValue.getValue());
        return testValue;
    }

    @RequestMapping("/hello/{id}")
    public TestValue index(@PathVariable Long id) {
        logger.debug("invoke!");
        logger.error("invoke!");
        return testService.find(id);
    }

    @RequestMapping(value = "/appname", produces = {"application/json"})
    public Model<String> getAppName() {
        logger.debug("Getting app name");
        return new Model<>("LiveLog, version 0.01");
    }
    
}
