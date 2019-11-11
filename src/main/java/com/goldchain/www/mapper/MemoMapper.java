package com.goldchain.www.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goldchain.www.domain.Memo;

@Mapper
public interface MemoMapper {
	ArrayList<Memo> selectAll();
	
	int selectMaxMMid();
	
	int insertMemo(Memo memo);
	
	int deleteMemo(int mmid);
	/***
	 * 最も入力されているデータを取得する
	 * @param mmsb メモ種別
	 * @return 最も入力されているメモの内容
	 */
	List<Memo> selectOrderManyMemoNaiyou(int mmsb);
}
