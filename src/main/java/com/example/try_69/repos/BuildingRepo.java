package com.example.try_69.repos;

import com.example.try_69.domain.Building;
import com.example.try_69.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface BuildingRepo extends CrudRepository<Building, Long> {

    Page<Building> findAll(Pageable pageable);

    Page<Building> findByCategory(String category, Pageable pageable);

    Page<Building> findByAuthor(User user, Pageable pageable);

}
