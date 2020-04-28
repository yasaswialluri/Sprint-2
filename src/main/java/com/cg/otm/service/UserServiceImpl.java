package com.cg.otm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.otm.dao.UserDao;
import com.cg.otm.entity.User;
import com.cg.otm.exception.UserException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User findUserById(int userId) throws UserException {
		if( ! userDao.existsById(userId))
		{
			throw new  UserException("User ID "+userId+" NOT FOUND ");
		}
		return  userDao.findById(userId).get();
	}


	@Override
	public User createUser(User user) {
		User t =  userDao.saveAndFlush(user);
		return t;
	}

	@Override
	public List<User> findAllUser() throws UserException {
		List<User> list =  userDao.findAll();
		return list;
	}

	@Override
	public User deleteUserById(int userId) throws UserException {
		User user =null;

		if(  userDao.existsById(userId))
		{
			user =  userDao.findById(userId).get();
			userDao.deleteById(userId);
		}
		else
		{
			throw new  UserException("User ID "+userId+" NOT FOUND " );
		}
		return user ;
	}

	@Override
	public User updateUser(int userId, User user) throws UserException {
		User  t=null;
		if( userDao.existsById(userId))
		{
			t=userDao.saveAndFlush(user);
		}
		else
		{
			throw new  UserException("User ID "+userId+" NOT FOUND ");
		}
		return t;
	}

}
