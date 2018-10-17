package com.zya.cloud.two.ui.test;

import java.util.Arrays;

/**
 * 根据快排查找第k大的数
 * 
 * @author zya
 *
 */
public class QuickSortTest {

	public static void main(String[] args) {

		int[] arr = new int[] { 23, 64, 12, 9, 87, 19 };
		int k = 6,j = k-1;
		System.out.println(Arrays.toString(arr));
		System.out.println(sort1(arr, 0, arr.length - 1, j));
		System.out.println(Arrays.toString(arr));
	}

	static int sort1(int[] arr, int left, int right, int k) {
		if (left < right) {
			int index = sort(arr, left, right);
			if (k < index) {
				sort1(arr, left, index - 1, k);
			} else if (k > index) {
				sort1(arr, index + 1, right, k);
			} else {
				return arr[k];
			}
		}
		return arr[k];
	}

	static int sort(int[] arr, int left, int right) {
		int base = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= base) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] <= base) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = base;
		return left;
	}

}
