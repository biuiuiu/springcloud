package com.zya.cloud.two.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.zya.cloud.two.entity.TestEntity;
import com.zya.cloud.two.serices.TwoServices;

@Controller
@Path(value = "two")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestResource {

	private static final Logger logger = Logger.getLogger(TestResource.class);

	@Autowired
	private TwoServices service;
	
	private static ExecutorService executorService = Executors.newFixedThreadPool(2);

	@GET
	@Path(value = "/showParam/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String showParam(@PathParam("param") String param) throws Exception {
		if (StringUtils.isEmpty(param)) {
			return null;
		}
		return service.showParam(param);
	}

	@GET
	@Path(value = "/dc/{param}")
	public String dc() {
		executorService.execute(new ThreadPoolTest());
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
		return String.valueOf(threadPoolExecutor.getActiveCount()) + "队列数量：" + threadPoolExecutor.getQueue().size();
	}

	/**
	 * 测试transient关键字，序列化时忽略字段，反序列化此字段为空
	 * 
	 * @return
	 */
	@GET
	@Path(value = "getObject")
	public TestEntity getObject() {
		TestEntity entity = new TestEntity();
		entity.setAge("12");
		entity.setName("zya");
		entity.setPassword("11");
		saveObj2File(entity, "C:\\个人文件\\test\\1.log");
		TestEntity entity2 = readFromFile("C:\\个人文件\\test\\1.log");
		System.out.println(entity2.toString());
		return entity2;
	}

	/**
	 * 对象写入文件持久化
	 * 
	 * @param entity
	 * @param filePath
	 * @return
	 */
	private boolean saveObj2File(TestEntity entity, String filePath) {
		if (java.util.Objects.isNull(entity) || StringUtils.isBlank(filePath)) {
			return false;
		}
		File file = new File(filePath);
		OutputStream out = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			out = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(out);
			objectOutputStream.writeObject(entity);
			// out.write(entity.toString().getBytes());
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				objectOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 从指定文件读取反序列化成对象
	 * 
	 * @param filePath
	 * @return
	 */
	private TestEntity readFromFile(String filePath) {
		TestEntity entity = new TestEntity();
		if (java.util.Objects.isNull(entity) || StringUtils.isBlank(filePath)) {
			return entity;
		}
		File file = new File(filePath);
		if (!file.exists()) {
			return entity;
		}
		InputStream in = null;
		ObjectInputStream inputStream = null;
		try {
			in = new FileInputStream(file);
			inputStream = new ObjectInputStream(in);
			entity = (TestEntity) inputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("对象反序列化错误");
		} finally {
			try {
				inputStream.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("流关闭错误");
			}
		}
		return entity;
	}

}
