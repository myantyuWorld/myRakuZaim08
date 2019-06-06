package com.goldchain.www.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldchain.www.bean.MoneyBean;
import com.goldchain.www.bean.ZaimBean;

@Service
public class ZaimBaseService {

	public MoneyBean jsonByZaimBean(String json) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			MoneyBean moneyBean= mapper.readValue(json,MoneyBean.class);
			
			return moneyBean;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		return null;
	}
	
}
