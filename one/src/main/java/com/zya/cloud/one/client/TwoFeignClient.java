package com.zya.cloud.one.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.zya.cloud.one.FeignCustomConf;
import com.zya.cloud.one.client.fallback.TwoFeignFallback;

@FeignClient(name = "two",configuration = FeignCustomConf.class, fallback = TwoFeignFallback.class)
public interface TwoFeignClient {

	@GET
	@Path(value = "two/showParam/{param}")
	public String showParam(@PathParam("param") String param);
}
