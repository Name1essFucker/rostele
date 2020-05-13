package com.example.try_69.service;

import com.example.try_69.domain.TechSupport;
import com.example.try_69.repos.TechSupportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TechSupportService {
    @Autowired
    private TechSupportRepo techSupportRepo;

    public Iterable<TechSupport> findAll() {
        return techSupportRepo.findAll();
    }

    public void saveTechSupport(TechSupport techSupport){
        techSupportRepo.save(techSupport);
    }
}
