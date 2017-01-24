package com.assignment3;

import java.util.Scanner;

public class MatrixSearch {

	static int[][] matrixArray = {
			{1,4,7,11,15},
			{2,5,8,12,19},
			{3,6,9,16,22},
			{10,13,14,17,24},
			{18,21,23,26,30}
	};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the element to be searched : " );
		int target = scanner.nextInt();
		boolean result = search(target, 5, 5);
		if(result) {
			System.out.println("Element is found");
		} else {
			System.out.println("Element not found");
		}
		scanner.close();
	}

	private static boolean search(int target, int rowSize, int columnSize) {
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				if(target == matrixArray[i][j]) {
					return true;
				}
            }
		}
		return false;
	}
	
}
