package com.assignment3;

import java.util.Scanner;

public class ArraySearch {

	private static int[] array = {1,1,2,2,3,4,5};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the element to be searched : " );
		int target = scanner.nextInt();
		int result = search(target);
		if(result != -1) {
			System.out.println("Element is found");
		} else {
			System.out.println("Element not found");
		}
		scanner.close();
	}

	private static int search(int target) {
		for (int i = 0; i < array.length; i++) {
			if(target == array[i]) {
				return 1;
			}
		}
		return -1;
	}

}
