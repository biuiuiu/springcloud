package com.zya.cloud.two.ui.test;

/**
 * 快速排序
 * 
 * @author zya
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] sortArray = new int[] { 4, 1, 98, 21, 3 };
		System.out.println(printArray(sortArray));
		sort(sortArray, 0, sortArray.length - 1);
		System.out.println(printArray(sortArray));

	}

	static void sort(int[] array, int left, int right) {
		int pivot = 0;
		if (left < right) {
			pivot = partArray(array, left, right);
			sort(array, left, pivot - 1);
			sort(array, pivot + 1, right);
		}
	}

	static int partArray(int[] array, int left, int right) {
		int l = left;
		int r = right;
		int base = array[l];
		while (l < r) {
			while (l < r & array[r] >= base) {
				r--;
			}
			array[l] = array[r];
			while (l < r & array[l] <= base) {
				l++;
			}
			array[r] = array[l];
		}
		array[l] = base;
		return l;
	}

	static String printArray(int[] sortArray) {
		String s = "";
		if (sortArray.length == 0) {
			return s;
		}
		for (int i = 0; i < sortArray.length; i++) {
			s = s.concat(sortArray[i] + " ");
		}
		return s;
	}

}
