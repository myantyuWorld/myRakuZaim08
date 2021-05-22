package com.goldchain.www.controller.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldchain.www.common.ResponseResult;
import com.goldchain.www.domain.UserService;
import com.goldchain.www.domain.pojo.Users;

@Controller
@RestController("userIndexController")
@RequestMapping("rakuzaim08/api/user")
public class IndexController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	@ResponseBody
	private String index() {
		return "hello api/user/indexController";
	}
	
	/***
	 * ユーザー作成し、ユーザーごとのテーブルを作成する処理
	 * @param user
	 * 		user
	 * @param result
	 * 		result
	 * @return
	 *  	処理結果
	 */
	@PostMapping("/add")
	@ResponseBody
	private ResponseResult add(@RequestBody Users user, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		try {
			if (this.userService.insert(user) > 0) {
				this.userService.createTable(user);
			}
		} catch (Exception e) {
			return new ResponseResult().createError();
		}
		
		return new ResponseResult().createSuccess();
	}
}
