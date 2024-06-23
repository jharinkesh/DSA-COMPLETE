package com.dsa.sorting.dsa10;

public class SalaryThreshold {

    public static void main(String[] args) {
	int t = 210;
	int[] s = { 20, 30, 40, 90, 100 };
	int temp = t / s.length;
	int count = 0, sum = 0;
	for (int e : s) {
	    if (e <= temp)
		sum += (temp - e);
	    else
		count++;
	}
	System.out.println(temp + (sum / count));
    }
}
