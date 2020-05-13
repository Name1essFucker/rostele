package com.example.try_69.repos;

import com.example.try_69.domain.TechSupport;
import com.example.try_69.domain.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TechSupportRepo extends CrudRepository<TechSupport, Long> {

    List<TechSupport> findAll();
}
