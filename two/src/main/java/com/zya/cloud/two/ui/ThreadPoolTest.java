package com.zya.cloud.two.ui;

public class ThreadPoolTest implements Runnable{

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(threadName);
	}

}
