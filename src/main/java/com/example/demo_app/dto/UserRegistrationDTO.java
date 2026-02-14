package com.example.demo_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Dùng Record (có từ Java 14+) là cách gọn nhất cho DTO
public record UserRegistrationDTO(
	@NotBlank(message = "Họ tên không được để trống")
	@Size(min = 2, max = 50, message = "Tên phải từ 2 đến 50 ký tự")
	String fullname,

	@NotBlank(message = "Email là bắt buộc")
	@Email(message = "Định dạng email không hợp lệ")
	String email
) {
	public String getFullname() {
		return this.fullname;
	}

	public String getEmail() {
		return this.email;
	}
}
