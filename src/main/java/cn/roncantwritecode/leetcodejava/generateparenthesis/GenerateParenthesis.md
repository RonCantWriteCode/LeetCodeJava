### 题目描述
22.括号生成

数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例 1:
```
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
```

示例 2:
```
输入：n = 1
输出：["()"]
```

提示：

* 1 <= n <= 8

### 题解

#### 算法1 回溯 O(4^n / sqrt(n))

根据2n进行递归，每个位置可以放左右括号两种情况，该题重点就是对于不合法的括号的判断退出。时间复杂度，（递归次数）*（递归函数本身的时间复杂度），本次时间复杂度=递归次数，根据查的资料，具体时间复杂度是O(4^n / sqrt(n))，参考「卡特兰数」。

```$java
public List<String> generateParenthesis(int n) {
    List<String> results = new ArrayList<>();

    StringBuffer result = new StringBuffer("");
    generateParenthesis(0, 0, n, result, results);
    return results;
}

private void generateParenthesis(int left, int right, int n, StringBuffer result, List<String> results) {
    // 如果左括号数量小于右括号数量，或者左右括号数量超过n，不合法
    if (left < right || left > n || right > n) {
        return;
    }
    if (left == n && right == n) {
        results.add(result.toString());
        return;
    }

    // 插入左括号
    result.append("(");
    generateParenthesis(left + 1, right, n, result, results);
    result.deleteCharAt(result.length() - 1);

    // 插入右括号
    result.append(")");
    generateParenthesis(left, right + 1, n, result, results);
    result.deleteCharAt(result.length() - 1);
}
```
