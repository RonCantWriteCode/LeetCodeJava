### 题目描述
70.爬楼梯

假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：
```
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
```

示例 2：
```
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
```


### 题解

#### 算法1 动态规划 O(n)
第i阶可以由以下两种方法得到：

- 在第i-1阶后向上爬一阶

- 在第i-2阶后向上爬2阶

也就是斐波那契数列，时间复杂度O(n)

```$java
/**
 * 动态规划，斐波那契数列 O(n)
 * @param n
 * @return
 */
public int climbStairs(int n) {
    if (n == 1) {
        return 1;
    } else if (n == 2) {
        return 2;
    }
    int[] resultArray = new int[n];
    resultArray[0] = 1;
    resultArray[1] = 2;
    for (int i=2; i<n; i++) {
        resultArray[i] = resultArray[i - 1] + resultArray[i - 2];
    }
    return resultArray[n - 1];
}
```