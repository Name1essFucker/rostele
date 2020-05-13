package com.example.try_69.controller;

import com.example.try_69.domain.Building;
import com.example.try_69.domain.TechSupport;
import com.example.try_69.domain.User;
import com.example.try_69.repos.TechSupportRepo;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/techsupport")
public class TechSupportController {

    @Autowired
    private TechSupportRepo techSupportRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Model model) {
        return "techSupport";
    }

    @GetMapping("/main")
    public String main(
            @RequestParam(required = false, defaultValue = "")
            Model model
    ){
        Iterable<TechSupport> techSupports;
        techSupports = techSupportRepo.findAll();

        model.addAttribute("techsupport", techSupports);
        return "main";
    }

    //Главное окно добавление
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String message,
            Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        TechSupport techSupport = new TechSupport(message, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            techSupport.setFilename(resultFilename);
        }

        techSupportRepo.save(techSupport);
        Iterable<TechSupport> techSupports = techSupportRepo.findAll();

        model.put("techsupports", techSupports);

        return "/";
    }
}
