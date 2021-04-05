package com.goldchain.www.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.goldchain.www.common._enum.Mmsb;
import com.goldchain.www.domain.pojo.Memo;
import com.goldchain.www.mapper.MemoMapper;

@Service
public class MemoService {

	@Autowired
	private MemoMapper memoMapper;
	
	@Transactional
	public void init(Model model) throws Exception {
		ArrayList<Memo> memoList = new ArrayList<>();
		List<Memo> memoPlaceHolderFoods = new ArrayList<>();
		List<Memo> memoPlaceHolderNichiyou = new ArrayList<>();
		// 日用品・食費の明細部取得
		memoList = memoMapper.selectAll();
		// 日用品・食費の予測入力部分取得
		memoPlaceHolderNichiyou = initPlaceHolderMemo(Mmsb.Nichiyou.ordinal());
		memoPlaceHolderFoods = initPlaceHolderMemo(2);
		
		model.addAttribute("memos", memoList);
		model.addAttribute("placeNichiyouList", memoPlaceHolderNichiyou);
		model.addAttribute("placeFoodList", memoPlaceHolderFoods);
	}
	
	// 2021/03/30 add Ajax化
	@Transactional
	public List<Memo> getMemoAll() {
		return this.memoMapper.selectAll();
	}
	
	// 2021/03/30 add Ajax化
	/***
	 * 入力回数の多いメモ内容を返す（最大100件、2回以上メモしているものを返す
	 * 種別＝｛日用品、食費｝の両方を返す
	 * @return
	 */
	@Transactional
	public List<Memo> getMemoDescriptionManyOrder() {
		return this.memoMapper.selectOrderManyMemoNaiyouAll();
	}
	
	@Transactional
	public int selectMaxMMid() {
		return memoMapper.selectMaxMMid();
	}
	
	@Transactional
	public int insertMemo(Memo memo) {
		return memoMapper.insertMemo(memo);
	}
	
	@Transactional
	public int deleteMemo(int mmid) {
		return memoMapper.deleteMemo(mmid);
	}
	
	/***
	 * 入力頻度の多いメモ内容をDB検索し返す
	 * @return 日用品、食費で入力頻度の多いメモ内用のリスト
	 * @throws Exception 
	 */
	@Transactional
	public List<Memo> initPlaceHolderMemo(int mmsb) throws Exception {
		List<Memo> memoList = this.memoMapper.selectOrderManyMemoNaiyou(mmsb);
		// 検索できないとき、例外をスローする
		if (memoList == null) {
			throw new Exception();
		}
		return memoList;
	}
}
