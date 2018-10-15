package com.zya.cloud.two.ui;

public class QueueTest<T> {

	private T[] elementData;
	private int maxSize;
	private int front;
	private int rear;

	public T[] getElementData() {
		return elementData;
	}

	public void setElementData(T[] elementData) {
		this.elementData = elementData;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public QueueTest() {
	}

	@SuppressWarnings("unchecked")
	public QueueTest(int maxSize) {
		if (maxSize == 0) {
			this.maxSize = 1;
		}
		this.front = 0;
		this.rear = 0;
		this.maxSize = maxSize;
		this.elementData = (T[]) new Object[this.maxSize];
	}

	public boolean isNull() {
		if (front == rear) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if ((rear + 1) % maxSize == front) {
			return true;
		}
		return false;
	}

	public void push(T data) {
		if (isFull()) {
			return;
		}
		elementData[rear] = data;
		rear = (rear + 1) % maxSize;
	}

	public T pop() {
		if (isNull()) {
			return null;
		}
		T t = elementData[front];
		front = (front + 1) % maxSize;
		return t;
	}

}
