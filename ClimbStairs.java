package com.assignment3;

import java.util.Scanner;

public class ClimbStairs {
	
	private static int fibbonocci(int n) {
	   if (n <= 3) {
	      return n;
	   } else {
		   return fibbonocci(n-1) + fibbonocci(n-2) +  fibbonocci(n-3);
	   }
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of stairs : " );
		int stair = scanner.nextInt();
		System.out.println("No of ways to climb to top : " + fibbonocci(stair));
		scanner.close();
    }
}
