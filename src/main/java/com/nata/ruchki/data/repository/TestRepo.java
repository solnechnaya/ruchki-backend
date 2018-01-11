package com.nata.ruchki.data.repository;

import com.nata.ruchki.data.entity.Test;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Oleg Zaidullin
 */
public interface TestRepo extends CrudRepository<Test,Long> {}
