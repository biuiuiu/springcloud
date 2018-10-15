package com.zya.cloud.two.ui;

public class TreeTest {
	
	private String data;
	private TreeTest left;
	private TreeTest right;
	
	public TreeTest(){}
	
	public TreeTest(String data,TreeTest left,TreeTest right){
		this();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TreeTest getLeft() {
		return left;
	}

	public void setLeft(TreeTest left) {
		this.left = left;
	}

	public TreeTest getRight() {
		return right;
	}

	public void setRight(TreeTest right) {
		this.right = right;
	}
	
	
}
