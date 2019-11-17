package com.goldchain.www.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.goldchain.www.bean.RakutenProperty;

@Service
public class RakutenService {

	@Autowired
	RakutenProperty rakutenProperty;

	public void init(Model model) {
		
	}
	
	
}
