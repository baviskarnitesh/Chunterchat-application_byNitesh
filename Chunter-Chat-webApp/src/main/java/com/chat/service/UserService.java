package com.chat.service;

import java.util.List;

import com.chat.dto.UserDto;
import com.chat.exception.UserException;
import com.chat.modal.User;
import com.chat.request.UpdateUserRequest;

public interface UserService {
	
	public User findUserProfile(String jwt);
	
	public User updateUser(Integer userId, UpdateUserRequest req) throws UserException;
	
	public User findUserById(Integer userId) throws UserException;
	
	public List<User> searchUser(String query);
}
