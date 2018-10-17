package com.zya.cloud.two.ui.test;

import java.util.Arrays;

/**
 * 归并排序
 * 
 * @author zya
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 16, 23, 2, 8, 10, 98, 102, 54,7,15};
		int[] temp = new int[arr.length];
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length - 1, temp);
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right)/2;
			sort(arr, left, mid, temp);
			sort(arr, mid + 1, right, temp);
			merge(arr, left, mid, right, temp);
		}
	}

	static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int l = left;
		int j = mid + 1;
		int k = 0;
		while (left <= mid && j <= right) {
			while (left <= mid && arr[left] <= arr[j]) {
				temp[k] = arr[left];
				k++;
				left++;
			}
			while ( j <= right && arr[left] > arr[j]) {
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		// 左边剩余数组
		while (left <= mid) {
			temp[k] = arr[left];
			k++;
			left++;
		}
		while (j <= right) {
			temp[k++] = arr[j++];
		}
		k = 0;
		while (l <= right) {
			arr[l++] = temp[k++];
		}
	}
}
