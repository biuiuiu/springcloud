package com.zya.cloud.two.ui;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.zya.cloud.two.serices.TwoServices;

@Controller
@Path(value = "two")
public class TestResource {

	@Autowired
	private TwoServices service;

	@GET
	@Path(value = "/showParam/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String showParam(@PathParam("param") String param) {
		if (StringUtils.isEmpty(param)) {
			return null;
		}
		return service.showParam(param);
	}

	@GetMapping("/consumer")
	public String dc() {
		return "one";
	}
}
