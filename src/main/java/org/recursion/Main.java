package org.recursion;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*sum(5, 0);
        System.out.println(sum(5));
        factorial(5, 1);
        System.out.println(factorial(5));
        reverseArray(new int[] {1, 2,3,4,5,6}, 0, 5);
        reverseArray(new int[] {1, 2,3,4,5,6}, 0);
        System.out.println(palindrome("rotor", 0, 4));
        System.out.println(palindrome("motor", 0, 4));*/
       /* System.out.println(fib(10));
        System.out.println(fib(1000, new Long[1001]));
        subSequences(0, new int[]{3,1,2}, new int[3]);
        subSequencesSum(0, new int[]{3,1,2}, new int[3], 3);
        System.out.println(singleSubSequencesSum(0, new int[]{3,1,2}, new int[3], 5));*/
        //System.out.println(subSequencesSumCount(0, new int[]{3,1,2}, new int[3], 3));
        /*combinationSum(new int[]{3,1,2}, new int[8], 0, 7, 0);
        combinationSum(new int[]{3,1,2}, new ArrayList<>(), 0, 7);*/
        /*List<Integer> list = new ArrayList<>();
        subsetSum(0, 0, new int[]{3,1,2}, list);
        Collections.sort(list);
        System.out.println(list);*/
        /*permutation(new int[]{1,2,3}, 0);
        nQueen(new int[4][4], 0);*/
        int[][] maze = {{1,0,0,0},
                        {1,1,0,1},
                        {1,1,0,0},
                        {1,1,1,1}};
        maze(maze, 0, 0, new StringBuilder(""), new int[maze.length][maze[0].length]);
    }

    public static void kPermutation(int n, int[] arr, int k) {

    }

    public static void maze(int[][] maze, int row, int col, StringBuilder res, int[][] visited) {

        if(row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(res);
            visited[row][col] = 0;
            return;
        }

        // down
        if(row < maze.length - 1 && maze[row + 1][col] == 1 && visited[row + 1][col] == 0) {
            res.append("D");
            visited[row][col] = 1;
            maze(maze, row + 1, col, res, visited);
            res.delete(res.length() - 1, res.length());
            visited[row][col] = 0;
        }

        //left
        if(col > 0 && maze[row][col - 1] == 1 && visited[row][col - 1] == 0) {
            res.append("L");
            visited[row][col] = 1;
            maze(maze, row, col - 1, res, visited);
            res.delete(res.length() - 1, res.length());
            visited[row][col] = 0;
        }

        //right
        if(col < maze[0].length - 1 && maze[row][col + 1] == 1 && visited[row][col + 1] == 0) {
            res.append("R");
            visited[row][col] = 1;
            maze(maze, row, col + 1, res, visited);
            res.delete(res.length() - 1, res.length());
            visited[row][col] = 0;
        }

        // up
        if(row > 0 && maze[row - 1][col] == 1 && visited[row - 1][col] == 0) {
            res.append("U");
            visited[row][col] = 1;
            maze(maze, row - 1, col, res, visited);
            res.delete(res.length() - 1, res.length());
            visited[row][col] = 0;

        }

    }

    public static void nQueen(int[][] board, int col) {
        if(col == board[0].length) {
            for(int row = 0; row < board.length; row++) {
                for(int c = 0; c < board[0].length; c++) {
                    System.out.print(board[row][c] + ", ");
                }
                System.out.println();
            }
            return;
        }

        for(int row = 0; row < board.length; row++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 1;
                //System.out.println(col + " " + row + " added");
                nQueen(board, col + 1);
                board[row][col] = 0;
                //System.out.println(col + " " + row + " removed");
            }

        }
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        // check left
        int horizontal = col;
        int vertical = row;

        while (horizontal > 0) {
            if(board[vertical][horizontal - 1] == 1)
                return false;
            horizontal--;
        }

        //check left up
        horizontal = col;
        vertical = row;
        while (vertical > 0 && horizontal > 0) {
            if(board[vertical - 1][horizontal - 1] == 1)
                return false;
            vertical--;
            horizontal--;
        }



        //check left down
        horizontal = col;
        vertical = row;
        while (vertical < board.length - 1 && horizontal > 0) {
            if(board[vertical + 1][horizontal - 1] == 1)
                return false;
            vertical++;
            horizontal--;
        }
        return true;
    }


    public static void permutation(int[] arr, int index) {
        if(index == arr.length) {
            Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
            System.out.println();
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permutation(arr, index + 1);
            swap(arr, index, i);
        }
    }


   /* public static void permutation(int[] arr, Set<Integer> visited, List<Integer> res) {
        if(ind == arr.length) {
            System.out.println(res);
            return;
        }

        for (int i = 0; i < arr.length; i++) {

        }

    }*/

    public static void subsetSum(int n, int sum, int[] arr, List<Integer> res) {
        if(n >= arr.length) {
            res.add(sum);
            System.out.print(sum + ", ");
            return;
        }
        subsetSum(n + 1, sum + arr[n], arr, res);
        subsetSum(n + 1, sum, arr, res);
    }

    public static void combinationSum(int[] arr, List<Integer> res, int n, int target) {
        if(n >= arr.length) {
            if(target == 0) {
                System.out.println(res);
            }
            return;
        }

        if(target >= arr[n]) {
            res.add(arr[n]);
            combinationSum(arr, res, n, target - arr[n]);
            res.remove(res.size() - 1);
        }
        combinationSum(arr, res, n + 1, target);
    }

    /** When include -> add to the aux array
     *  When exclude -> remove from the aux array
     *  */
    public static void combinationSum(int[] arr, int[] res, int n, int target, int i) {
        if(target == 0) {
            Arrays.stream(res)
                    .filter(num -> num > 0)
                    .forEach(num -> System.out.print(num + ", "));
            System.out.println();
            return;
        }

        if(n >= arr.length)
            return;

        if(target >= arr[n]) {
            res[i] = arr[n];
            combinationSum(arr, res, n, target - arr[n], i + 1);
            res[i] = 0;
        }
        combinationSum(arr, res, n + 1, target, i);
    }

    public static int subSequencesSumCount(int n, int[] data, int[] arr, int target) {
        if(target == 0) {
            Arrays.stream(arr)
                    .filter(num -> num > 0)
                    .forEach(num -> System.out.print(num + ", "));
            System.out.println();
            return 1;
        }

        if(n >= data.length)
            return 0;

        arr[n] = data[n];
        int include = subSequencesSumCount(n + 1, data, arr, target - arr[n]);
        arr[n] = 0;
        int exclude = subSequencesSumCount(n + 1, data, arr, target);
        return include + exclude;
    }

    public static boolean singleSubSequencesSum(int n, int[] data, int[] arr, int target) {
        if(target == 0) {
            Arrays.stream(arr)
                    .filter(num -> num > 0)
                    .forEach(num -> System.out.print(num + ", "));
            System.out.println();
            return true;
        }

        if(n >= data.length)
            return false;

        arr[n] = data[n];
        if(singleSubSequencesSum(n + 1, data, arr, target - data[n]) == true)
            return true;
        arr[n] = 0;
        if(singleSubSequencesSum(n + 1, data, arr, target) == true)
            return true;
        return false;
    }

    public static void subSequencesSum(int n, int[] data, int[] arr, int target) {
        if(target == 0) {
            Arrays.stream(arr)
                    .filter(num -> num > 0)
                    .forEach(num -> System.out.print(num + ", "));
            System.out.println();
            return;
        }

        if(n >= data.length) {
            return;
        }

        arr[n] = data[n];
        subSequencesSum(n + 1, data, arr, target - arr[n]);
        arr[n] = 0;
        subSequencesSum(n + 1, data, arr, target);
    }



    public static void subSequences(int n, int[] data, int[] arr) {
        if(n >= data.length) {
            Arrays.stream(arr)
                    .filter(num -> num > 0)
                    .forEach(num -> System.out.print(num + ", "));
            System.out.println();
            return;
        }
        arr[n] = data[n];
        subSequences(n + 1, data, arr);
        arr[n] = 0;
        subSequences(n + 1, data, arr);
    }

    public static long fib(int n, Long[] cache) {
        if(n <= 1)
            return 1l;
        if(cache[n] != null)
            return cache[n];
        return cache[n] = fib(n - 1, cache) + fib(n - 2, cache);
    }
    public static int fib(int n) {
        if(n <= 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static boolean palindrome(String str, int l, int r) {
        if(l >= r) {
            return true;
        }
        if(str.charAt(l) != str.charAt(r))
            return false;

        return palindrome(str, l + 1, r - 1);
    }

    public static void reverseArray(int[] arr, int i) {
        int r = arr.length - i - 1;
        if(i >= r) {
            Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
            System.out.println();
            return;
        }

        swap(arr, i, r);
        reverseArray(arr, i + 1);
    }

    public static void reverseArray(int[] arr, int l, int r) {
        if(l >= r) {
            Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
            System.out.println();
            return;
        }
        swap(arr, l, r);
        reverseArray(arr, l + 1, r - 1);
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static int factorial(int n) {
        if(n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void factorial(int n, int factorial) {
        if(n == 1) {
            System.out.println(factorial);
            return;
        }
        factorial(n - 1, factorial * n);
    }

    /** Sum */

    public static void sum(int n, int sum) {
        if(n == 0) {
            System.out.println(sum);
            return;
        }
        sum += n;
        sum(n - 1, sum);
    }

    public static int sum(int n) {
        if(n == 0)
            return n;
        return sum(n - 1) + n;
    }
}