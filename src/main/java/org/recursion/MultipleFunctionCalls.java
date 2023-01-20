package org.recursion;

public class MultipleFunctionCalls {
    public static void main(String[] args) {
        //System.out.println(fibonacci(6));
        /*stairsJumps(3, "");
        System.out.println(stairsJumps(3));*/
        System.out.println(stairsJumpInfo(3));
    }



    public static int stairsJumps(int num) {
        if(num < 0)
            return 0;

        if(num == 0) {
            return 1;
        }

        return stairsJumps(num - 1) + stairsJumps(num - 2);
    }

    public static void stairsJumps(int num, String jumps) {
        if(num < 0)
            return;

        if(num == 0) {
            System.out.println(jumps);
            return;
        }

        stairsJumps(num - 1, jumps + "1 ");
        stairsJumps(num - 2, jumps + "2 ");
    }

    public static int stairsJumpInfo(int num) {
        if(num < 0)
            return 0;

        if(num == 0) {
            return 1;
        }

        int oneJump = stairsJumpInfo(num - 1);
        int twoJump = stairsJumpInfo(num - 2);
        int jumps = oneJump + twoJump;
        return jumps;
    }

    public static int fibonacci(int n) {
        if(n < 2)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
