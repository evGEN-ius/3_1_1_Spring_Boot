package org.example.Spring_Boot_3_1_1.controller;

import org.example.Spring_Boot_3_1_1.model.User;
import org.example.Spring_Boot_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) { this.userService = userService; }

	@GetMapping("/")
	public String listUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "index";
	}
	@PostMapping("/add")
	public String addUser(@ModelAttribute(value = "user") User user) {
		userService.add(user);
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		userService.delete(id);
		return "redirect:/";
	}
	@PostMapping("/update")
	public String updateUser(@ModelAttribute(value = "user") User user) {
		userService.update(user);
		return "redirect:/";
	}
	
}