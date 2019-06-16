package com.goldchain.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.goldchain.www.domain.Category;

@Mapper
public interface CategoryMapper {

	ArrayList<Category> selectAll();
}
