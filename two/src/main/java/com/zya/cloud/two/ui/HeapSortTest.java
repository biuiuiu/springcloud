package com.zya.cloud.two.ui;

import java.util.Arrays;

/**
 * 堆排序
 * 
 * @author an
 *
 */
public class HeapSortTest {

	public static void main(String[] args) {
		int[] array = new int[] { 21, 12, 1, 90, 67, 78, 43, 21, 34 };
		buildHeap(array, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	static void buildHeap(int[] array, int length) {
		int parentIndex = length > 2 ? ((length - 2) >> 1) : 0;
		for (int i = parentIndex; i >= 0; i--) {
			heapSort(array, i, length);
		}
		if (length > 0) {
			int temp = array[length];
			array[length] = array[0];
			array[0] = temp;
			length--;
			buildHeap(array, length);
		}
	}

	static void heapSort(int[] array, int index, int length) {
		int leftChild = (index << 1) + 1;
		int rightChild = (index << 1) + 2;
		int max = index;
		if (leftChild <= length && array[leftChild] > array[index]) {
			max = leftChild;
			int temp = array[index];
			array[index] = array[leftChild];
			array[leftChild] = temp;
		}
		if (rightChild <= length && array[rightChild] > array[index]) {
			max = rightChild;
			int temp = array[index];
			array[index] = array[rightChild];
			array[rightChild] = temp;
		}
		if (index != max) {
			heapSort(array, max, length);
		}
	}

}
