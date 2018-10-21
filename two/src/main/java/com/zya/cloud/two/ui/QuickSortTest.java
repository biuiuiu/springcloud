package com.zya.cloud.two.ui;

import java.util.Scanner;

public class QuickSortTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int _n;
		_n = Integer.parseInt(in.nextLine().trim());

		int _m;
		_m = Integer.parseInt(in.nextLine().trim());

		res = josephus(_n, _m);
		System.out.println(String.valueOf(res));

	}

	static int josephus(int n, int m) {
		int[] arr = new int[n];
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		int length = arr.length;
		while (length > m) {
			int k = 0;
			int left = 0;
			int right = arr.length;
			while (left < m && m <= right) {
				left++;
			}
			arr[m] = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					temp[k] = arr[i];
					k++;
				}
			}
			arr = temp;
			length--;
		}
		return arr[0];

	}

}
