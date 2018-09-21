package com.singeev.estate.controller;

import com.singeev.estate.entity.forms.UserForm;
import com.singeev.estate.service.FormConverter;
import com.singeev.estate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private FormConverter formConverter;

    @RequestMapping("/admin/users/create")
    public String showUserCreatePage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "editUser";
    }

    @RequestMapping("/admin/users/edit/{id}")
    public String showUserCreatePage(@PathVariable Long id,  Model model) {
        UserForm userForm = userService.findById(id).map(formConverter::userToForm).orElse(new UserForm());
        model.addAttribute("userForm", userForm);
        return "editUser";
    }
    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }



    @RequestMapping(value="/admin/users/save", method = RequestMethod.POST)
    public String saveOrUpdateUser(
            final UserForm userForm, final ModelMap model) {
        userService.save(formConverter.formToUser(userForm));
        model.clear();
        return "redirect:/admin";
    }
}
