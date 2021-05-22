package com.goldchain.www.domain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goldchain.www.domain.pojo.Category;
import com.goldchain.www.mapper.CategoryMapper;

@Service
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Transactional
	public ArrayList<Category> selectAll() {
		return this.categoryMapper.selectAll();
	}
}
