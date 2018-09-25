package com.zya.cloud.two.serices.impl;

import org.springframework.stereotype.Service;

import com.zya.cloud.two.serices.TwoServices;


@Service
public class TwoServicesImpl implements TwoServices{

	@Override
	public String showParam(String param) throws Exception {
		if ("error".equals(param)) {
			throw new Exception("測試而已");
		}
		return "my services name is two and param is " + param ;
	}

}
