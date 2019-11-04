package com.goldchain.www.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import com.goldchain.www.domain.Memo;

@Mapper
public interface MemoMapper {
	ArrayList<Memo> selectAll();
	
	int selectMaxMMid();
	
	int insertMemo(Memo memo);
	
	int deleteMemo(int mmid);
	
	ArrayList<Memo> selectOrderManyMemoNaiyou();
}
