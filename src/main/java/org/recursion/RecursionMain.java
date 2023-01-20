package org.recursion;

import java.util.*;

public class RecursionMain {
    public static void main(String[] args) {
        //System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7,8}, 0, 8, 10));
        /*printNto1(5);
        print1toN(5);*/
        //System.out.println(sum(5));
        //System.out.println(fact(5));
        //System.out.println(fib(1426, new Long[2000]));
        //System.out.println(Arrays.toString(allIndices(new int[]{1, 2, 56, 3, 4, 2, 78, 2, 3}, 0, 2, 0)));
        String[] codes = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "uvw", "xyz"};
        // subSequence("", "abc");
        System.out.println(keypadCodes(678, codes));
    }


    public static List<String> keypadCodes(int digits, String[] codes) {
        int num = digits % 10;
        if(digits <= 10) {
            return new LinkedList<>(List.of(codes[num - 1].split("")));
        }
        List<String> returnedCodes = keypadCodes(digits / 10, codes);
        List<String> newCodes = new LinkedList<>();
        String code = codes[num - 1];
        for(int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            for (String returnedCode : returnedCodes) {
                newCodes.add(ch + returnedCode);
            }
        }
        return newCodes;
    }


    /*public static List<String> keypad(String num, String[] codes) {
        int ch = Integer.parseInt(Character.toString(num.charAt(0)));
        if(num.length() == 1) {
            //int ch = Integer.parseInt(Character.toString(num.charAt(0)));
            return new ArrayList<>(Arrays.asList(codes[ch - 1].split("")));
        }

        List<String> returnedCodes = keypad(num.substring(1), codes);
        String code = codes[ch - 1];
        List<String> newCodes =  new ArrayList<>();
        for(int i = 0; i < code.length(); i++) {
            //System.out.print(code.charAt(i) + " ");
            for (String returnedCode : returnedCodes) {
                newCodes.add(code.charAt(i) + returnedCode);
            }
        }
        return newCodes;
    }*/

    public static void subSequence(String sub, String str) {
        if(str.isEmpty()) {
            System.out.println(sub);
            return;
        }
        subSequence( sub + str.charAt(0), str.substring(1));
        subSequence(sub, str.substring(1));
    }

    public static int[] allIndices(int[] arr, int idx, int num, int count) {
        if(arr.length == idx) {
            return new int[count];
        }
        if(arr[idx] == num) {
            int[] counts = allIndices(arr, idx + 1, num, count + 1);
            counts[count] = idx;
            return counts;
        } else
            return allIndices(arr, idx + 1, num, count);
    }
    public static void allIndices(int[] arr, int idx, int num) {
        if(idx == arr.length)
            return;

        if(arr[idx] == num) {
            System.out.println(idx);
        }
        allIndices(arr, idx + 1, num);
    }

    public static long fib(int n, Long[] cache) {
        if(n < 2)
            return n;

        if(cache[n] != null)
            return cache[n];

        long leftTree = fib(n - 1, cache);
        long rightTree = fib(n - 2, cache);

        return cache[n] = leftTree + rightTree;
    }

    public static int fib(int n) {
        if(n < 2)
            return n;
        int leftTree = fib(n - 1);
        int rightTree = fib(n - 2);
        return leftTree + rightTree;
    }

    public static int fact(int n) {
        if(n <= 1)
            return 1;
        int fact = fact(n - 1);
        int res = n * fact;
        return res;
    }


    public static int sum(int n) {
        if(n == 0)
            return n;
        int sum = n + sum(n - 1);
        return sum;
    }

    public static void print1toN(int n) {
        if(n == 0)
            return;
        print1toN(n - 1);
        System.out.println(n);
    }

    public static void printNto1(int n) {
        if(n == 0)
            return;
        System.out.println(n);
        printNto1(n - 1);
    }
    public static int binarySearch(int[] arr, int l, int r, int num) {

        if(l >= r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if(arr[mid] == num)
            return mid;

        if(arr[mid] > num)
            return binarySearch(arr, l, mid, num);
        else
            return binarySearch(arr, mid + 1, r, num);
    }
}

