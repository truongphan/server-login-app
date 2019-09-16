package com.training.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.dao.UserDao;
import com.training.model.User;
import com.training.model.UserDto;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// check user is exist or not in database
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Bad credentials");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	public User save(UserDto user) {
		User newUser = new User();
	    newUser.setUsername(user.getUsername());
	    newUser.setFirstName(user.getFirstName());
	    newUser.setLastName(user.getLastName());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setAge(user.getAge());
		newUser.setSalary(user.getSalary());
        return userDao.save(newUser);
	}

	public List<User> findAll() {
		return userDao.findAll().stream().collect(Collectors.toList());
	}

	public void delete(int id) {
		userDao.deleteById(id);
	}

	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	public User findById(int id) {
		return userDao.findById(id).get();
	}

	public UserDto update(UserDto userDto) {
		User user = findById(userDto.getId());
        if(user != null) {
            BeanUtils.copyProperties(userDto, user, "password");
            userDao.save(user);
        }
        return userDto;
	}
}
