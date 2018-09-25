package com.zya.cloud.one.client.fallback;

import org.springframework.stereotype.Component;

import com.zya.cloud.one.client.TwoFeignClient;

import feign.hystrix.FallbackFactory;

@Component
public class TwoFallbackFactory implements FallbackFactory<TwoFeignClient>{

	@Override
	public TwoFeignClient create(Throwable arg0) {
		System.out.println("111111111111111==========="+arg0.getMessage());
		return new TwoFeignFallback();
	}

}
