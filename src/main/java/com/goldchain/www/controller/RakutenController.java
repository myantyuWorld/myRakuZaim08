package com.goldchain.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goldchain.www.domain.RakutenService;

@Controller
public class RakutenController {

	@Autowired
	private RakutenService rakutenService;
	
	/***
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("pages/rakuten")
	private String index(Model model) {
		this.rakutenService.init(model);
		return "pages/rakuten/index";
	}
}
