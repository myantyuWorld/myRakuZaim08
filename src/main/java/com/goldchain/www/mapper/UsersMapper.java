package com.goldchain.www.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.goldchain.www.domain.pojo.Memo;
import com.goldchain.www.domain.pojo.Users;

@Mapper
public interface UsersMapper {
	ArrayList<Users> selectAll();
	
	int insert(Users user);
	
	int createTable(Users user);
}
