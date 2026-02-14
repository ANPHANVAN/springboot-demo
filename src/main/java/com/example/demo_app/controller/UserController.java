package com.example.demo_app.controller;

import com.example.demo_app.dto.UserRegistrationDTO;
import com.example.demo_app.model.User;
import com.example.demo_app.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping("")
	public List<User> getAllUser() {
		System.out.println("Go hear");
		return userService.getAllUser();
	}

	@PostMapping("")
	public User createUser(@Valid @RequestBody UserRegistrationDTO userInfo) {
		return userService.createUser(userInfo.getFullname(), userInfo.getEmail());
	}

}
