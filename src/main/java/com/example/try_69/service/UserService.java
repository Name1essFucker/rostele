package com.example.try_69.service;

import com.example.try_69.domain.Role;
import com.example.try_69.domain.User;
import com.example.try_69.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);
    }

    public void updateProfile(User user, String password, String mail, String userPhoneNumber) {
        if(!StringUtils.isEmpty(password)){
            user.setPassword(password);
        }
        if(!StringUtils.isEmpty(mail)){
            user.setMail(mail);
        }
        if(!StringUtils.isEmpty(userPhoneNumber)){
            user.setUserPhoneNumber(userPhoneNumber);
        }
        userRepo.save(user);
    }

    public void deleteProfile(User user){
        userRepo.delete(user);
    }
}
