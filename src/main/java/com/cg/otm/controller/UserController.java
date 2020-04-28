package com.cg.otm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.otm.entity.User;

import com.cg.otm.exception.UserException;

import com.cg.otm.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	UserService  userService;

	@GetMapping("user/{id}")
	public  ResponseEntity<User>  findUserById(@PathVariable("id")  int id) throws UserException
	{

		User  user = userService.findUserById(id);
		ResponseEntity<User>  re = new ResponseEntity<User>(user,HttpStatus.OK);
		return re;
	}

	@PostMapping("user")
	public ResponseEntity<User>  createUser(@RequestBody User user)
	{
		User  t = userService.createUser(user);
		ResponseEntity<User>  re = new ResponseEntity<User>(t,HttpStatus.OK);
		return re;
	}



	@GetMapping("user")
	public ResponseEntity<List<User>>  findAllUser() throws  UserException
	{

		List<User> list = userService.findAllUser();
		ResponseEntity<List<User>>  rt = new ResponseEntity<List<User>>(list,HttpStatus.OK);
		return rt;

	}

	@DeleteMapping("user/{id}")
	public  ResponseEntity<User>  deleteUserById(@PathVariable("id") int userId) throws  UserException
	{

		ResponseEntity<User>  rt = null;


		User t =userService.deleteUserById(userId);
		rt= new ResponseEntity<User>(t,HttpStatus.OK);

		return rt;
	}

	@PutMapping("user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int userId,@RequestBody User user) throws  UserException

	{
		User t = userService.updateUser(userId,user);
		ResponseEntity<User> re = new ResponseEntity<User>(t, HttpStatus.OK);
		return re;
	}


}
