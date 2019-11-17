package com.goldchain.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.goldchain.www.bean.RakutenCategory.Result.RecipeCategory;

@Mapper
public interface RakutenCategoryMapper {

	int insertRakutenCategory(RecipeCategory recipeCategory);
}
