package com.goldchain.www.controller.regist;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goldchain.www.bean.RegistForm;
import com.goldchain.www.domain.common.CategoryService;

@Controller
public class RegistController {
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/pages/regist")
	public String index(Model model) {
		// 
		model.addAttribute("categoryList", this.categoryService.selectAll());
		
		return "pages/regist/index";
	}
	
	@ResponseBody
	@PostMapping("/pages/regist/post")
	public void post(@ModelAttribute("form") @Valid RegistForm form, BindingResult result, Model model) {
		// Formクラスでのバリデーションエラーチェック
		if (result.hasErrors()) {
			
		}
		
		System.out.println("test");
	}
}
