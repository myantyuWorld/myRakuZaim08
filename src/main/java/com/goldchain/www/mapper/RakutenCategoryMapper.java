package com.goldchain.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.goldchain.www.bean.RecipeCategory;

@Mapper
public interface RakutenCategoryMapper {

	int insertRakutenCategory(RecipeCategory recipeCategory);
	int insertRakutenCategoryLarge(RecipeCategory recipeCategory);
	int insertRakutenCategoryMedium(RecipeCategory recipeCategory);
	int insertRakutenCategorySmall(RecipeCategory recipeCategory);
	ArrayList<RecipeCategory> selectByCgsb(int cgsb);
}
