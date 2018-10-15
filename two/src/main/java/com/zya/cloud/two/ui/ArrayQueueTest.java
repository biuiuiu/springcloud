package com.zya.cloud.two.ui;

public class ArrayQueueTest extends Throwable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7218958869518842435L;

	public static void main(String[] args) {
		QueueTest<String> queueTest = new QueueTest<>(5);
		System.out.println(queueTest.getMaxSize());
		queueTest.push("1");
		queueTest.push("2");
		queueTest.push("3");
		queueTest.push("4");
		System.out.println(queueTest.isFull());
		System.out.println(queueTest.getFront());
		System.out.println(queueTest.getRear());
		
		queueTest.pop();
		queueTest.pop();
		queueTest.pop();
		queueTest.pop();
		System.out.println(queueTest.isNull());
		System.out.println(queueTest.getFront());
		System.out.println(queueTest.getRear());
	}
}
