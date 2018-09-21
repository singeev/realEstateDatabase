package com.singeev.estate.service;

import com.singeev.estate.entity.User;
import com.singeev.estate.entity.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FormConverter {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserService userService;

    public User formToUser(UserForm form) {
        User user =  new User(
                form.getFirstName(),
                form.getSecondName(),
                form.getLastName(),
                form.getEmail(),
                form.getPhone(),
                encoder.encode(form.getPassword()),
                new ArrayList<>()
        );
        user.setId(form.getId());
        user.getRoles().add(userService.findByName("ROLE_USER"));
        return user;
    }

    public UserForm userToForm(User user) {
        return new UserForm(
                user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                null
        );
    }
}
