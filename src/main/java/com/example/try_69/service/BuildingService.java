package com.example.try_69.service;

import com.example.try_69.domain.Building;
import com.example.try_69.repos.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
        @Autowired
        private BuildingRepo buildingRepo;

        public void deleteOffer(Building building) {
                buildingRepo.delete(building);
        }
}
