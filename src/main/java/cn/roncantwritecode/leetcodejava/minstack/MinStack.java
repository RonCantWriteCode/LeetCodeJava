package cn.roncantwritecode.leetcodejava.minstack;

import java.util.Stack;

/**
 * @author wurunlong
 * @date 2020/4/2
 */
public class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        if (data.isEmpty()) {
            return;
        }
        int top = data.pop();
        if (min.peek() == top) {
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
