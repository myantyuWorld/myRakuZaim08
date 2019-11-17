package com.goldchain.www.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.goldchain.www.bean.RakutenProperty;

@Service
public class RakutenService {

	private static final Logger logger = LoggerFactory.getLogger(RakutenService.class);
	
	@Autowired
	RakutenProperty rakutenProperty;

	public void init(Model model) {
		// TODO log
		logger.info(rakutenProperty.getRakutenApplicationId());
		logger.info(rakutenProperty.getRakutenApplicationSecret());
	}
	
	
}
