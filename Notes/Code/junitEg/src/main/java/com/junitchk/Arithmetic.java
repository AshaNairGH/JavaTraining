package com.junitchk;

public class Arithmetic {

	public Arithmetic() {
		System.out.println("Arithmetic()");
	}

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		return a / b;
	}

	public double max(double a, double b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
	
	public int[] reverse(int []arr) {
		int t = 0;
		int n = arr.length;
		for (int i = 0; i<n/2;i++) {
			t = arr[i];
			arr[i]=arr[n-i-1];
			arr[n-i-1]=t;
		}
		System.out.println("reverse()");
		return arr;
	}
}
