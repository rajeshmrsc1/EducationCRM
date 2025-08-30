package com.example.crmdemo.main.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserDTO {

	private Long Id;

	@NotBlank(message = " name is required")
	private String name;
	@Email(message = "email should be valid")
	private String email;
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
	private String phoneno;
     @NotBlank(message = " city is required")
	private String city;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserDTO [Id=" + Id + ", name=" + name + ", email=" + email + ", phoneno=" + phoneno + ", city=" + city
				+ "]";
	}

}
