package org.recursion;

import java.util.Stack;

public class StackRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(10);
        stack.add(3);
        stack.add(24);
        stack.add(2);
        sort(stack);

        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

    /**
     *  1. Empty the whole stack by popping elements and storing in variable
     *  2. Pass the above variable into the insert function to be inserted back into the stack in a sorted position
     *  Insertion -> Descending order
     *  3. If the stack is empty or the element at the top position is smaller than the above variable then insert the above variable
     *  4. Else keep popping the top till the stack becomes empty or the stack top element is smaller than the element to be inserted
     *  5. Finally, insert the popped element back into the stack
     */

    public static void sort(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int top = stack.pop();
            sort(stack);
            insert(stack, top);
        }
    }

    public static void insert(Stack<Integer> stack, int val) {
        if(stack.isEmpty() || stack.peek() > val) {
            stack.push(val);
            return;
        }
        int top = stack.pop();
        insert(stack, val);
        stack.push(top);
    }
}
