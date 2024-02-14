package com.reviewsystem.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {

	private Long id;
	
	@NotEmpty
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String firstName;
	@NotEmpty
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String lastName;
	@NotEmpty
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String username;
	@Email(message = "Email address is not valid !!")
	@NotEmpty(message = "Email is required !!")
	private String email;
	private String mobile;
	@NotEmpty
	@Size(min = 4, max = 10, message = "Password must be min of 3 chars and max of 10 chars !!")
	private String password;

	public UserDTO() {

	}

	public UserDTO(Long id, String firstName, String lastName, String username, String email, String mobile,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", mobile=" + mobile + ", password=" + password + "]";
	}

	
	
}
