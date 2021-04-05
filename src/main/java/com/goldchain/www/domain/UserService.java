package com.goldchain.www.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goldchain.www.domain.pojo.Users;
import com.goldchain.www.mapper.UsersMapper;

@Service
public class UserService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Transactional
	public List<Users> selectAll() {
		return this.usersMapper.selectAll();
	}
	
	@Transactional
	public int insert(Users user) {
		return this.usersMapper.insert(user);
	}
	
	@Transactional
	public int createTable(Users user) {
		return this.usersMapper.createTable(user);
	}
	
}
