package com.zya.cloud.one;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.jaxrs.JAXRSContract;

@Configuration
public class FeignCustomConf {
	
	@Bean
	public JAXRSContract contract() {
		return new JAXRSContract();
	}
}
