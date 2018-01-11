package com.nata.ruchki.data.repository;

import com.nata.ruchki.data.service.TestService;
import com.nata.ruchki.data.value.TestValue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Oleg Zaidullin
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TestServiceTest {

    @Autowired
    public TestRepo repo;

    private TestService testService;

    @Before
    public void setUp() {
        testService = new TestService(repo);
    }

    @Test
    public void simpleTest() {
        testService.add(new TestValue(null,"message"));
        TestValue testValue = testService.find(1L);
        assertEquals(testValue, new TestValue(1L,"message"));
    }
}
