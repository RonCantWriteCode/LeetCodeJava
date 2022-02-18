### 题目描述
155.最小栈

设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
示例：
```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
```

### 题解

#### 算法1 最小栈 O(1)

- 当最小栈为空时，最小栈也入栈
- 当新的数小于等于最小栈顶数值时，最小栈也入栈。（等于时需要放入重复数值）
- 出栈时，当数值等于最小栈栈顶时，最小栈也出栈

```$java
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
}
```
