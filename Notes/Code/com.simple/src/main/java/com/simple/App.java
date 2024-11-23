package com.simple;

import java.util.Scanner;

import com.utils.ArrayUtils1;

public class App {
public static void main(String[] args) {
	int arr[] = new int[5];
	Scanner scnr = new Scanner(System.in);
	
	for(int i = 0;i<5;i++)
	{
		System.out.println("Enter next value and press Enter");
		int val = scnr.nextInt();
		arr[i] = val;
	}
	
	ArrayUtils1 obj = ArrayUtils1.getInstance(arr);
	int min_result = obj.min();
	
	ArrayUtils1 obj1 = ArrayUtils1.getInstance(arr);
	ArrayUtils1 obj2 = ArrayUtils1.getInstance(arr);
	System.out.println(min_result);
}
}
/*#1. Make changes in given Singleton example, so that getInstance() methods return already existing object(instead of null)
		  when called multiple times?

		#2. Create an Array of Strings, develop logic to find alphabetically minimum String and print*/