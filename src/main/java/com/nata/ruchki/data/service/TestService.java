package com.nata.ruchki.data.service;

import com.nata.ruchki.data.repository.TestRepo;
import com.nata.ruchki.data.entity.Test;
import com.nata.ruchki.data.value.TestValue;
import org.springframework.stereotype.Service;

/**
 * @author Oleg Zaidullin
 */
@Service
public class TestService {

    private TestRepo testRepo;

    public TestService(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    public Long add(TestValue testValue) {
        Test result = testRepo.save(toEntity(testValue));
        return result.getId();
    }

    public TestValue find(Long id) {
        return toValue(testRepo.findOne(id));
    }

    private TestValue toValue(Test entity) {
        return new TestValue(entity.getId(),entity.getMessage());
    }

    private Test toEntity(TestValue testValue) {
        return new Test(testValue.getMessage());
    }
}
