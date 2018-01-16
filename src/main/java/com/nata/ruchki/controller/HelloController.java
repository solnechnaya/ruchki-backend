package com.nata.ruchki.controller;

import com.nata.ruchki.data.service.CategoryService;
import com.nata.ruchki.data.service.TestService;
import com.nata.ruchki.data.value.CategoriesValue;
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
    private CategoryService categoryService;

    public HelloController(TestService testService, CategoryService categoryService) {

        this.testService = testService;
        this.categoryService = categoryService;
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

    @RequestMapping(value = "/category", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public Model<Long> addCategory(@RequestBody CategoriesValue categoriesValue) {
        Long id = categoryService.add(categoriesValue);
        return new Model<>(id);
    }


}
