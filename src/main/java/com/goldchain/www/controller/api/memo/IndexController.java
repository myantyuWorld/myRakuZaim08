package com.goldchain.www.controller.api.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldchain.www.domain.CategoryService;

@Controller
@RestController("memoIndexController")
@RequestMapping("rakuzaim08/api/memo")
public class IndexController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/")
	@ResponseBody
	private String index() {
		return "hello api/memo/indexController";
	}
}