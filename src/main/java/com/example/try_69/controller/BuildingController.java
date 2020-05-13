package com.example.try_69.controller;

import com.example.try_69.domain.Building;
import com.example.try_69.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping("delete/{building}")
    public String deleteOffer(
            @PathVariable Building building
    ){
            buildingService.deleteOffer(building);
            return "redirect:/main";
    }
}
