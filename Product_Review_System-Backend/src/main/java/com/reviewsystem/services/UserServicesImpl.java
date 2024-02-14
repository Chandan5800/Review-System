package com.reviewsystem.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reviewsystem.Dto.LoginDTO;
import com.reviewsystem.Dto.UserDTO;
import com.reviewsystem.model.User;
import com.reviewsystem.repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addUser(UserDTO userDTO) {

		User user = new User(userDTO.getId(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getUsername(),
				userDTO.getEmail(), userDTO.getMobile(),

				this.passwordEncoder.encode(userDTO.getPassword()));
		userRepository.save(user);
		return user.getFirstName();

	}

	UserDTO userDTO;

	@Override
	public LoginMessage loginUser(LoginDTO loginDTO) {
		String msg = "";
		User user1 = userRepository.findByUsername(loginDTO.getUsername());

		if (user1 != null) {
			String password = loginDTO.getPassword();
			String encodePassword = user1.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
			if (isPwdRight) {
				Optional<User> user = userRepository.findOneByUsernameAndPassword(loginDTO.getUsername(),
						encodePassword);
				if (user.isPresent()) {
					return new LoginMessage("Login Success", true);
				} else {
					return new LoginMessage("Login Failed", false);
				}
			} else {
				return new LoginMessage("password Not Match", false);
			}
		} else {
			return new LoginMessage("Email not exits", false);
		}
	}
	
	 @Override
	    public boolean usernameExists(String username) {
	        User user = userRepository.findByUsername(username);
	        return user != null;
	    }

}
