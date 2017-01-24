package com.assignment2;

import java.util.NoSuchElementException;

public class Stack {
	// Array used to store elements
	int[] stackArray;
	int topElement, size;

	public Stack(int size) {
		this.topElement = -1;
		// Declaring the size of the array
		this.size = size;
		// Initialize the Array
		this.stackArray = new int[size];
	}

	public Stack() {
		this.topElement = -1;
		// Declaring the size of the array with default size 5.
		this.size = 5;
		// Initialize the Array
		this.stackArray = new int[size];
	}

	/*
	 * Checks whether a stack is empty or not
	 */
	public boolean isEmpty() {
		return (topElement == -1);
	}

	/*
	 * if stack is empty then throws an exception else returns the top most
	 * element in the stack
	 */
	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty...!!!");
		}
		return stackArray[topElement];
	}

	/*
	 * if stack is full then throws an exception else store element in the stack
	 */
	public void push(int i) {
		if (topElement + 1 >= size)
			throw new IndexOutOfBoundsException("Overflow Exception");
		if (topElement + 1 < size)
			stackArray[++topElement] = i;
	}

	/*
	 * if stack is empty then throws an exception else returns the deletes
	 * element in the stack
	 */
	public int pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty...!!!");
		}
		return stackArray[topElement--];
	}
}
