### 题目描述
461.汉明距离

两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 2的31方.

示例:
```
输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。
```


### 题解

#### 算法1 异或 O(1)

异或之后统计1的数量

```$java
/**
 * 异或 O(n)
 * @param x
 * @param y
 * @return
 */
public int hammingDistance(int x, int y) {
    int result = x ^ y;
    return Integer.bitCount(result);
//        int count = 0;
//        while (result != 0) {
//            if ((result & 1) == 1) {
//                count++;
//            }
//            result = result >> 1;
//        }
//        return count;
}
```