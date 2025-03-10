package com.user.model;

public class User {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String role;
	private String password;

	// Default constructor
	public User() {
		super();
	}

	// Constructor without ID
	public User(String name, String email, String phone, String address, String role, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.password = password;
	}

	// Constructor with all fields
	public User(int id, String name, String email, String phone, String address, String role, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.password = password;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Print user details
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", role=" + role + ", password=" + password + "]";
	}
}
