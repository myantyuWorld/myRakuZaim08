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
import com.goldchain.www.controller.ZaimInfo;
import com.goldchain.www.domain.ZaimApiService;
import com.goldchain.www.domain.common.CategoryService;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;

@Controller
@RequestMapping("pages/regist")
public class RegistController {
	
//	@Autowired
//	ZaimInfo zaiminfo;
	
	@Autowired
	OAuthConsumer consumer;
	
	@Autowired
	OAuthProvider provider;
	
	@Autowired
	CategoryService categoryService;
    
    @Autowired
    ZaimApiService zaimApiService;

	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("categoryList", this.categoryService.selectAll());
		return "pages/regist/index_material";
	}
	
	@ResponseBody
	@PostMapping("/post")
	public Object post(@ModelAttribute @Valid RegistForm form, BindingResult result, Model model) {
		System.out.println("");
		// Formクラスでのバリデーションエラーチェック
		if (result.hasErrors()) {
			return false;
		}
		// Zaimへ送信する
		
		
		return true;
	}
}
