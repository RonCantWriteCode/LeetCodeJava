package cn.roncantwritecode.leetcodejava.isvalid;

import java.util.Stack;

/**
 * @author Ron Wu
 * @date 2020/3/25
 */
public class IsValid {
    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        String str = "{[]}";
        boolean result = isValid.isValid(str);
        System.out.println(result);

    }

    /**
     * 栈 O(n)
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (char c : chars) {
            switch (c) {
                case '(' :
                case '[' :
                case '{' :
                    stack.push(c);
                    break;
                case ')' :
                    if (!stack.empty() && '(' == (char)stack.peek()) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ']' :
                    if (!stack.empty() && '[' == (char)stack.peek()) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case '}' :
                    if (!stack.empty() && '{' == (char)stack.peek()) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
            }

        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
