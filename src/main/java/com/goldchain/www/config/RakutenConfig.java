package com.goldchain.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.goldchain.www.bean.RakutenProperty;

@Configuration
public class RakutenConfig {

	@Bean
	RakutenProperty rakutenProperty() {
		return new RakutenProperty();
	}
}
