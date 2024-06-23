package com.dsa.math;

import java.math.BigInteger;

public class Demo1 {

    public static void main(String[] args) {
//        digits(123);
//        System.out.println(reverse(1230));
//        System.out.println(palindrome(121));
//        System.out.println(gcd0(25,50));
//        System.out.println(isPrime(4));
//        System.out.println(fact2(500));
//        System.out.println(trailZero(100));
//        System.out.println(lcm(12,15));

        String x = "123";
        System.out.println(x.substring(0,0));
    }

    static void primeFactors(int n){

    }

    static int trailZero(int n){
        int r = 0;
        for(int i=5;i<=n;i*=5){
            r += (n/i);
        }
        return r;
    }

    static int fact(int n){
        int r = 1;
        for(int i=n;i>0;i--){
            r = r *i;
        }
        return r;
    }

    static String fact2(int n){
        BigInteger r = BigInteger.valueOf(1);

        for(int i=n;i>0;i--){
            r = r.multiply(BigInteger.valueOf(i));
        }
        return r.toString();
    }

    static boolean isPrime(int n){
        if(n ==0 || n == 1)
            return false;
        for(int i=2;i<=n/2;i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    static int lcm(int a , int b){
        return a*b/gcd(a,b);
    }

    static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

    static int gcd0(int a, int b){
        while(a!=b){
            if(a>b)
                a = a-b;
            else
                b = b-a;
        }
        return a;
    }

    static void digits(int n){
        while(n>0){
            int x = n%10;
            System.out.println(x);
            n = n/10;
        }
    }

    static boolean palindrome(int n){
        return reverse(n) == n;
    }

    static int reverse(int n){
        int rev = 0;
        while(n>0){
            int r = n%10;
            rev = rev*10 + r;
            n = n/10;
        }
        return rev;
    }
}
