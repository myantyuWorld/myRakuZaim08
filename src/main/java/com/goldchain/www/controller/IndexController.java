package com.goldchain.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping
	private String index() {
		return "pages/index/index";
	}
}
