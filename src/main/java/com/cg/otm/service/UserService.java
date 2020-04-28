package com.cg.otm.service;

import java.util.List;
import com.cg.otm.entity.User;
import com.cg.otm.exception.UserException;

public interface UserService {
	public User findUserById(int userId) throws UserException ;

	public  User  createUser (User  user);

	public List<User >  findAllUser () throws  UserException;

	public User  deleteUserById(int userId) throws  UserException;

	public User updateUser(int userId,User  user) throws  UserException;
}
