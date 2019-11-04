package com.goldchain.www.domain;

import java.util.ArrayList;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.goldchain.www.mapper.MemoMapper;

@Service
public class MemoService {

	@Autowired
	private MemoMapper memoMapper;
	
	@Transactional
	public ArrayList<Memo> selectAll() {
		return memoMapper.selectAll();
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
	public ArrayList<Memo> initPlaceHolderMemo() throws Exception {
		ArrayList<Memo> memos = new ArrayList<Memo>();
		memos = this.memoMapper.selectOrderManyMemoNaiyou();
		// 検索できないとき、例外をスローする
		if (CollectionUtils.isEmpty(memos)) {
			throw new Exception();
		}
		return memos;
		
	}
}
