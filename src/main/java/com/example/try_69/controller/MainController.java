package com.example.try_69.controller;

import com.example.try_69.domain.Building;
import com.example.try_69.domain.User;
import com.example.try_69.repos.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Controller
@EnableTransactionManagement
public class MainController {

    @Autowired
    private BuildingRepo buildingRepo;

    @Value("${upload.path}")
    private String uploadPath;

    //Начальная страница
    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    //Страница помощь
    @GetMapping("/help")
    public String help(Model model) {
        return "help";
    }

    //Главное окно получение
    @GetMapping("/main")
    public String main(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<Building> page;

        if (filter != null && !filter.isEmpty()) {
            page = buildingRepo.findByCategory(filter, pageable);
        } else {
            page = buildingRepo.findAll(pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("url", "/main");
        model.addAttribute("filter", filter);

        return "main";
    }

    //Главное окно добавление
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Building building,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ) throws IOException {

        Page<Building> page;

        building.setAuthor(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("building", building);
        } else {
            saveFile(building, file);

            model.addAttribute("building", null);
            buildingRepo.save(building);
        }
        Iterable<Building> buildings = buildingRepo.findAll();
        page = buildingRepo.findAll(pageable);

        model.addAttribute("buildings", buildings);
        model.addAttribute("page", page);
        model.addAttribute("url", "/main");

        return "redirect:/main";
    }

    //Сохранение изображения
    private void saveFile(
            @Valid Building building,
            @RequestParam("file") MultipartFile file) throws IOException {
            if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            building.setFilename(resultFilename);
        }
    }

    //Мои предложения
    @GetMapping("/users-offers/{user}")
    public String usersOffers(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Building building,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<Building> page;
        page = buildingRepo.findByAuthor(user, pageable);

        Set<Building> buildings = user.getBuildings();

        model.addAttribute("buildings", buildings);
        model.addAttribute("building", building);
        model.addAttribute("isCurrentUser", currentUser.equals(user));
        model.addAttribute("url", "/user-offers/" + user.getId());
        model.addAttribute("page", page);

        return "usersOffers";
    }

    //Изменение предложения
    @PostMapping("/users-offers/{user}")
    public String updateOffer(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long user,
            @RequestParam("id") Building building,
            @RequestParam("title") String title,
            @RequestParam("address") String address,
            @RequestParam("price") Long price,
            @RequestParam("category") String category,
            @RequestParam("area") String area,
            @RequestParam("description") String description,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        if (building.getAuthor().equals(currentUser)) {
            if (!StringUtils.isEmpty(title)) {
                building.setTitle(title);
            }
            if (!StringUtils.isEmpty(address)) {
                building.setAddress(address);
            }
            if (!StringUtils.isEmpty(price)) {
                building.setPrice(price);
            }
            if (!StringUtils.isEmpty(category)) {
                building.setCategory(category);
            }
            if (!StringUtils.isEmpty(area)) {
                building.setArea(area);
            }
            if (!StringUtils.isEmpty(description)) {
                building.setDescription(description);
            }
            if (!StringUtils.isEmpty(email)) {
                building.setEmail(email);
            }
            if (!StringUtils.isEmpty(phoneNumber)) {
                building.setPhoneNumber(phoneNumber);
            }
            saveFile(building, file);
            buildingRepo.save(building);
        }
        return "redirect:/users-offers/" + user;
    }

    //Вся информация
    @GetMapping("/fullInfo/{building}")
    public String fullInfo(@PathVariable Building building) {
        return "fullInfo";
    }
}