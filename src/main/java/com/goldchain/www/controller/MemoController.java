package com.goldchain.www.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goldchain.www.bean.MemoForm;
import com.goldchain.www.domain.Memo;
import com.goldchain.www.domain.MemoService;
import com.goldchain.www.domain.SlackBaseService;

@Controller
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	@Autowired
	private SlackBaseService slackBaseService;
	
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
	 * @throws Exception 
	 */
	@ResponseBody
	@PostMapping("/pages/memo/post")
	private Object post(@ModelAttribute @Valid Memo memo,  BindingResult result) throws Exception
	{
		// 入力チェック
		if (result.hasErrors()) {
			return null;
		}
		int intMaxMMid = memoService.selectMaxMMid();
		memo.setMmid(intMaxMMid);
		if (memoService.insertMemo(memo) > 0) {
			// slack api call
//			slackBaseService.helloWorldToSlackBot();
			slackBaseService.notifyMemoToSlackBot(memo.getMmnm());
		} else {
			throw new Exception();
		}
		return memo;
	}
	
	/***
	 * メモ内容を削除
	 * @param memo
	 * @return
	 */
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
	/***
	 * 
	 * @param memo
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@PostMapping("pages/memo/initPlaceHolderMemo")
	private ArrayList<Memo> initPlaceHolderMemo(@ModelAttribute Memo memo) throws Exception
	{
		return this.memoService.initPlaceHolderMemo();
	}
	
}
