package com.example.demo_app.model;

import jakarta.persistence.*;

@Entity // Đánh dấu đây là một thực thể Hibernate
@Table(name = "users") // Tên bảng trong Postgres
public class User {
	public User(String username, String email) {
		this.username = username;
		this.email = email;
	}

	@Id // Khóa chính
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng (Serial trong Postgres)
	private Long id;

	@Column(nullable = false, unique = true) // Ràng buộc: không null, duy nhất
	private String username;

	private String email;

	// Getter và Setter (Hoặc dùng Lombok @Data)

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
