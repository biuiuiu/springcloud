package com.zya.cloud.one.ui;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zya.cloud.one.services.TestServices;

@Controller
@Path("/one")
public class TestResource {
	
	@Autowired
	private TestServices service;
	
	@GET
	@Path(value = "getTwoServiceInterface/{param}")
	public String getTwoServiceInterface(@PathParam("param") String param){
		if (StringUtils.isEmpty(param)) {
			return null;
		}
		return service.getTwoServiceInterface(param);
	}
}
