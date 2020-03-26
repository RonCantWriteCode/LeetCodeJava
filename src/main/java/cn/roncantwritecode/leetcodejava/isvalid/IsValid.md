### 题目描述
20.有效的括号

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。

左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串。


示例1:
```
输入: "()"
输出: true
```

示例2:
```
输入: "()[]{}"
输出: true
```

示例3:
```
输入: "(]"
输出: false
```

示例4:
```
输入: "([)]"
输出: false
```

示例5:
```
输入: "{[]}"
输出: true
```


### 题解

#### 算法1 栈 O(n)

使用栈，当为左括号时入栈中，依次匹配，成功时出栈。非括号字符不做处理。时间复杂度O(n)

```$java
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

```