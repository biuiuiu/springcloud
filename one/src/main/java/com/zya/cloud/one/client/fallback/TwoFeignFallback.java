package com.zya.cloud.one.client.fallback;

import org.springframework.stereotype.Component;

import com.zya.cloud.one.client.TwoFeignClient;

@Component
public class TwoFeignFallback implements TwoFeignClient {

	@Override
	public String showParam(String param) {

		return "fallback " + param;
	}

}
