package com.zya.cloud.one.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zya.cloud.one.client.TwoFeignClient;
import com.zya.cloud.one.services.TestServices;

@Service
public class TestServicesImpl implements TestServices {

	@Autowired
	private TwoFeignClient client;

	@Override
	public String getTwoServiceInterface(String param) {
		return client.showParam(param);
	}

}
