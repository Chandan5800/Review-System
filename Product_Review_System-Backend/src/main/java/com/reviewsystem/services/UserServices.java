package com.reviewsystem.services;

import com.reviewsystem.Dto.LoginDTO;
import com.reviewsystem.Dto.UserDTO;

public interface UserServices {

	String addUser(UserDTO userDTO);

	LoginMessage loginUser(LoginDTO loginDTO);

	boolean usernameExists(String username);
}
