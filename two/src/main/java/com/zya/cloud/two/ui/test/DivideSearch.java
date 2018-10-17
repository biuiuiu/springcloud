package com.zya.cloud.two.ui.test;

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
			System.out.println(mid);
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
	
	static void getIndexFibonacci(int[] arr,int k){
		int[] fibonacci = getFibonacci(20);
		int index = 0;
		for (int i = 0; i < fibonacci.length; i++) {
			if (fibonacci[i] > arr.length) {
				index = i;
				break;
			}
		}
	}
	
	static int[] getFibonacci(int maxSize){
		if (maxSize < 2) {
			return null;
		}
		int[] fibonacci = new int[maxSize];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			fibonacci[i] = fibonacci[i-1]+fibonacci[i-2];
		}
		return fibonacci;
	}
}
