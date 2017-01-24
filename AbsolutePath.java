package com.assignment2;

import java.util.Scanner;

public class AbsolutePath {
	
	// path = "/a/./b/../../c/", => "/c"
	// path = "/../", => "/"
	public static String getPath(String path) {
		StringBuffer buffer = new StringBuffer();
		String[] subPaths = path.split("/");
		java.util.Stack<String> stack = new java.util.Stack<String>();
		for (String subPath : subPaths) {
			if (subPath.length() == 0 || subPath.equals(".")) {
			} else if (subPath.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(subPath);
			}
		}
		if (stack.isEmpty()) {
			buffer.append('/');
		} else {
			while (!stack.isEmpty()) {
				buffer.insert(0, stack.pop());
				buffer.insert(0, '/');
			}
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the path : ");
		String path = scanner.next();
		System.out.println(path + " => " + getPath(path));
		scanner.close();
	}
}
