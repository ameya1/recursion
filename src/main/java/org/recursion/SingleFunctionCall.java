package org.recursion;

public class SingleFunctionCall {
    public static void main(String[] args) {
        //printIncreasing(5);
        //printIncreasing(5);
        //System.out.println(factorial(5));
        //System.out.println(pow(4, 4));
        //printDecreasingIncreasing(5);
        /*System.out.println(sum(5));
        System.out.println(sumInfo(5));*/
        System.out.println(prod(5));
    }

    public static int prod(int n) {
        if(n == 1)
            return 1;
        return n * prod(n - 1);
    }

    public static int sum(int n) {
        if(n == 0)
            return 0;
        return n + sum(n - 1);
    }

    public static int sumInfo(int n) {
        if(n == 0)
            return 0;
        int num = sumInfo(n - 1);
        int sum = n + num;
        System.out.println("n : " + n + "  + num : " + num + " sum : " + sum);
        return sum;
    }

    public static int pow(int n, int k) {
        if(k == 1)
            return n;
        return n * pow(n, k - 1);
    }

    public static int factorial(int n) {
        if(n == 0)
            return 1;
        int fact = factorial(n - 1);
        int result = n * fact;
        return result;
    }

    public static void printDecreasingIncreasing(int n) {
        if(n == 0) {
            System.out.println();
            return;
        }
        System.out.println(n);
        printDecreasingIncreasing(n - 1);
        System.out.println(n);

    }

    public static void printDecreasing(int n) {
        if(n == 0)
            return;
        System.out.println(n);
        printDecreasing(n - 1);
    }

    public static void printIncreasing(int n) {
        if(n == 0)
            return;
        printIncreasing(n - 1);
        System.out.println(n);
    }
}
