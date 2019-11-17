package com.goldchain.www.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goldchain.www.domain.RakutenService;

@Controller
public class RakutenController {

	private static final Logger logger = LoggerFactory.getLogger(RakutenController.class);
	
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
	
	@ResponseBody
	@RequestMapping("pages/rakuten/categoryImport")
	private Object categoryImport() {
		logger.info("call categoryImport()");
		try {
			if (this.rakutenService.rakutenCategoryImport() > 0) {
				return "1"; // success
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0"; // failed
	}
}
