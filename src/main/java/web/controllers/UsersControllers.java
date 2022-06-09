package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import javax.validation.Valid;


@Controller
public class UsersControllers {
    private UserService userService = new UserServiceImpl();

    @Autowired
    public UsersControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers (Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "index";
    }
    @GetMapping("/{id}")
    public String showUser (@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "/showUser";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user")@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/new";
        }
        userService.createUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findUserById(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id")int id) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}
