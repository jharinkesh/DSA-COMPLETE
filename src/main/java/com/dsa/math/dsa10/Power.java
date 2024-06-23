package com.dsa.math.dsa10;

public class Power {

    public static void main(String[] args) {

	System.out.println(power(3, 4));
    }

    static int power(int x, int y) {
	if (y == 0)
	    return 1;
	int p = power(x, y / 2);
	p = p * p;
	if (y % 2 != 0)
	    p = p * x;
	return p;
    }

}
