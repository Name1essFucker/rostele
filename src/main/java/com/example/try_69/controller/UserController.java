package com.example.try_69.controller;

import com.example.try_69.domain.Role;
import com.example.try_69.domain.User;
import com.example.try_69.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
            ) {
        userService.saveUser(user, username, form);

        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(
            Model model,
            @AuthenticationPrincipal User user
    ){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("mail", user.getMail());
        model.addAttribute("userPhoneNumber", user.getUserPhoneNumber());

        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String mail,
            @RequestParam String userPhoneNumber
    ){
        userService.updateProfile(user, password, mail, userPhoneNumber);

        return "redirect:/user/profile";
    }

    @GetMapping("delete/{user}")
    public String deleteProfile(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user
            ){
        if(!user.equals(currentUser)){
            userService.deleteProfile(user);
            return "redirect:/user";
        }else {
            userService.deleteProfile(user);
            return "redirect:/login";
        }
    }
}
