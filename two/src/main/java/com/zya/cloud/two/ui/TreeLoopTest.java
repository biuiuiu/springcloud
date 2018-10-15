package com.zya.cloud.two.ui;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class TreeLoopTest {
	
	private static int sum = 0;

	private static TreeTest init() {
		TreeTest treeTest1 = new TreeTest("2", null, null);
		TreeTest treeTest2 = new TreeTest("1", null, null);
		TreeTest treeTest3 = new TreeTest("8", treeTest1, treeTest2);
		TreeTest treeTest4 = new TreeTest("9", null, null);
		TreeTest treeTest5 = new TreeTest("11", treeTest4, treeTest3);
		return treeTest5;
	}

	private static void treeSum(TreeTest treeTest) {
		if (null == treeTest) {
			return;
		}
		sum += Integer.valueOf(treeTest.getData());
		if (null != treeTest.getLeft()) {
			treeSum(treeTest.getLeft());
		}
		if (null != treeTest.getRight()) {
			treeSum(treeTest.getRight());
		}
	}

	public static void main(String[] args) {
		TreeTest test = init();
		treeSum(test);
//		SoftReference<TreeTest> softReference = new SoftReference<TreeTest>(test);//软引用
//		test = null;
//		System.gc();
//		System.out.println(softReference.get().getData());
		WeakReference<TreeTest> weakReference = new WeakReference<TreeTest>(test);//弱引用
		test = null;
		System.gc();
		System.out.println(weakReference.get().getData());
		
	}
}
