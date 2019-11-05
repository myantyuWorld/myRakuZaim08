package com.goldchain.www.domain;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.ibatis.io.ResolverUtil.IsA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Memo initPlaceHolderMemo(int mmsb) throws Exception {
		Memo memo = this.memoMapper.selectOrderManyMemoNaiyou(mmsb);
		// 検索できないとき、例外をスローする
		if (memo == null) {
			throw new Exception();
		}
		return memo;
	}
}
