package com.assignment2;

import java.util.Scanner;

public class StackTest {
	public static void main(String[] args) {
		Stack stack = new Stack();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("\n***********************************");
			System.out.println("1.push");
			System.out.println("2.pop");
			System.out.println("3.peek");
			System.out.println("4.empty");
			System.out.println("5.exit");
			System.out.println("\n***********************************");
			System.out.print("\nEnter your choice : ");
			int choice = scanner.nextInt();
			try {
				switch (choice) {
				case 1:
					System.out.print("\nEnter an element push to stack : ");
					int pushElement = scanner.nextInt();
					stack.push(pushElement);
					System.out.println("Element " + pushElement + " is pushed to the stack");
					break;
				case 2:
					System.out.println(stack.pop() + " is popped from stack");
					break;
				case 3:
					System.out.println(stack.peek() + " is top element in stack");
					break;
				case 4:
					System.out.println(stack.isEmpty() ? "stack is empty" : "stack is not empty");
					break;
				case 5:
					System.exit(0);
					break;
				default:
				}
			} catch (Exception e) {
				System.out.println("\n" + e.getMessage());
			}
		} while (true);
	}
}
