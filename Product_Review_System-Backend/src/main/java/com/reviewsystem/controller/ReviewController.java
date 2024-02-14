package com.reviewsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reviewsystem.Dto.LoginDTO;
import com.reviewsystem.Dto.UserDTO;
import com.reviewsystem.services.LoginMessage;
import com.reviewsystem.services.UserServices;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/users")

public class ReviewController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/save")
	public String saveUser(@RequestBody UserDTO userDTO) {
		userDTO.setFirstName(userDTO.getFirstName()); 
		userDTO.setFirstName(userDTO.getFirstName()); 
		userDTO.setUsername(userDTO.getUsername());
		userDTO.setEmail(userDTO.getEmail());
		userDTO.setMobile(userDTO.getMobile());
		userDTO.setPassword(userDTO.getPassword());

		String id = userServices.addUser(userDTO);
		return id;
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
		LoginMessage loginResponse = userServices.loginUser(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
	
	@GetMapping("/checkUsername")
	public ResponseEntity<?> checkUsernameExists(@RequestParam String username) {

	    boolean usernameExists = userServices.usernameExists(username);

	    if (usernameExists) {
	        return ResponseEntity.badRequest().body("Username already exists. Please choose another one.");
	    } else {
	        return ResponseEntity.ok("Username is available.");
	    }
	}

}
