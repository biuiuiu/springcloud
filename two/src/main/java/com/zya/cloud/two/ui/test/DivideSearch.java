package com.zya.cloud.two.ui.test;

import java.util.Arrays;

/**
 * 二分查找
 * 
 * @author zya
 *
 */
public class DivideSearch {
	public static void main(String[] args) {
		int[] arr = new int[] { 12, 21, 25, 56, 78 };
		int index = 0;
		System.out.println(getIndex(arr, 0, arr.length - 1, 56, index));
		System.out.println(getIndex(arr, 56));
		System.out.println(getIndexFibonacci(arr, 56));
	}

	static int getIndex(int[] arr, int left, int right, int k, int index) {

		int mid = (left + right) / 2;
		if (k < arr[mid]) {
			return getIndex(arr, left, mid - 1, k, index);
		} else if (k > arr[mid]) {
			return getIndex(arr, mid + 1, right, k, index);
		} else {
			index = mid;
			return index;
		}

	}

	/**
	 * 差值查找
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	static int getIndex(int[] arr, int k) {
		int left = 0, right = arr.length - 1;
		while (left < right) {
			// 差值查找
			int mid = left + (k - arr[left]) * arr.length / (arr[right] - arr[left]);
			if (arr[mid] < k) {
				left = mid + 1;
			} else if (arr[mid] > k) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * 斐波那契查找方法
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	static int getIndexFibonacci(int[] arr, int key) {
		int[] fibonacci = getFibonacci(20);
		int index = 0;
		int left = 0;
		int right = arr.length - 1;
		for (int i = 0; i < fibonacci.length; i++) {
			if (fibonacci[i] > arr.length) {
				index = i;
				break;
			}
		}
		int[] newArray = Arrays.copyOf(arr, fibonacci[index]);
		// 补齐数组到f[index]的长度
		for (int i = right + 1; i < fibonacci[index]; i++) {
			newArray[i] = arr[right];
		}
		while (left <= right) {
			int mid = left + fibonacci[index - 1] - 1;
			if (key < newArray[mid]) {
				right = mid - 1;
				index = index - 1;
			} else if (key > newArray[mid]) {
				left = mid + 1;
				index = index - 2;
			} else {
				return mid;
			}
		}
		return -1;
	}

	static int[] getFibonacci(int maxSize) {
		if (maxSize < 2) {
			return null;
		}
		int[] fibonacci = new int[maxSize];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		return fibonacci;
	}
}
