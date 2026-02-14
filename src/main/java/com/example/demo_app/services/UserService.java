package com.example.demo_app.services;

import com.example.demo_app.model.User;
import com.example.demo_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	// Lưu User mới vào DB
	public User createUser(String name, String email) {
		User newUser = new User(name, email);
		return userRepository.save(newUser); // Tương đương INSERT INTO users...
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	// Tìm User theo ID
	public User getUserById(Long id) {
		return userRepository.findById(id) // Tương đương SELECT * FROM users WHERE id = ?
			.orElseThrow(() -> new RuntimeException("Không tìm thấy User"));
	}

	// Tìm User theo Email
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email)
			.orElseThrow(() -> new RuntimeException("Email không tồn tại"));
	}
}