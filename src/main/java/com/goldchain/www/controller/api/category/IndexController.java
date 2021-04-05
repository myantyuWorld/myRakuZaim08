package com.goldchain.www.controller.api.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldchain.www.domain.MemoService;

@Controller
@RestController("categoryIndexController")
@RequestMapping("rakuzaim08/api/category")
public class IndexController {
	
	@Autowired
	private MemoService memoService;

	@RequestMapping("/")
	@ResponseBody
	private String index() {
		return "hello api/category/indexController";
	}
}
