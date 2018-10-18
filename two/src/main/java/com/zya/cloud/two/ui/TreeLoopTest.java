package com.zya.cloud.two.ui;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import org.apache.commons.lang.StringUtils;

public class TreeLoopTest {
	
	private static int sum = 0;

	private static TreeTest init() {
		TreeTest treeTest1 = new TreeTest("1", null, null);
		TreeTest treeTest2 = new TreeTest("2", null, null);
		TreeTest treeTest3 = new TreeTest("3", null, null);
		TreeTest treeTest4 = new TreeTest("4", null, null);
		TreeTest treeTest5 = new TreeTest("5", treeTest2, treeTest1);
		TreeTest treeTest6 = new TreeTest("6", treeTest4, treeTest3);
		TreeTest treeTest7 = new TreeTest("7", treeTest6, treeTest5);
		return treeTest7;
	}

	private static void treeSum(TreeTest treeTest) {
		if (null == treeTest || StringUtils.isBlank(treeTest.getData())) {
			return;
		}
//		System.out.println(treeTest.getData());//先序遍历
		treeSum(treeTest.getLeft());
//		System.out.println(treeTest.getData());//中序遍历
		treeSum(treeTest.getRight());
		System.out.println(treeTest.getData());//后序遍历
	}

	public static void main(String[] args) {
		TreeTest test = init();
		treeSum(test);
	}
}
