package com.assignment3;

public class SortingColor {
	
	public static void main(String[] args) {
		int[] colorsArray = {2,3,4,2,3,4};
		System.out.print("Before Color Sorting : ");
		printArray(colorsArray, colorsArray.length);
		for (int i = 0; i < colorsArray.length; i++) {
			for (int j = i+1; j < colorsArray.length; j++) {
				if(colorsArray[i] < colorsArray[j]) {
					int temp = colorsArray[j];
					colorsArray[j] = colorsArray[i];
					colorsArray[i] = temp;
				}
            }
        }
		System.out.print("After Color Sorting : ");
		printArray(colorsArray, colorsArray.length);
    }
	
	private static void printArray(int[] colorsArray, int size) {
		for (int i = 0; i < size; i++) {
	        System.out.print(colorsArray[i] + " ");
        }
		System.out.println();
	}
	
}
