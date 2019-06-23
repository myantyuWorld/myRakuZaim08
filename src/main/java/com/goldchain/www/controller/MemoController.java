package com.goldchain.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goldchain.www.bean.MemoForm;
import com.goldchain.www.domain.Memo;
import com.goldchain.www.domain.MemoService;

@Controller
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	/***
	 * index method
	 * @param model
	 * @return
	 */
	@RequestMapping("/pages/memo")
	private String index(Model model)
	{
		ArrayList<Memo> memos = new ArrayList<>();
		memos = memoService.selectAll();
		
		model.addAttribute("memos", memos);
		
 		return "pages/memo/index";
	}
	
	/***
	 * 入力したメモをINSERTする
	 * @param memo
	 * @return
	 */
	@ResponseBody
	@PostMapping("/pages/memo/post")
	private Object post(@ModelAttribute Memo memo)
	{
		System.out.println(memo.getMmnm());
		int intMaxMMid = memoService.selectMaxMMid();
		int intInsertResult = 0;
		if (intMaxMMid != 0) {
			memo.setMmid(intMaxMMid);
			intInsertResult = memoService.insertMemo(memo);
		}
		return memo;
	}
	
	@ResponseBody
	@PostMapping("pages/memo/delete")
	private int delete(@ModelAttribute Memo memo) 
	{
		int intDeleteResult = 0;
		System.out.println(memo.getMmid());
		if (memo != null) {
			intDeleteResult = memoService.deleteMemo(memo.getMmid());
		}
		
		return intDeleteResult;
	}
	
}
