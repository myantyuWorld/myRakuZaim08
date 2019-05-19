package com.goldchain.www.domain;

import java.util.ArrayList;

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
}
